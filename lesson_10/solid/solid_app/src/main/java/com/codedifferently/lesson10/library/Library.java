package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Represents a library. */
public class Library {
  private Set<String> bookIds = new HashSet<>();
  private Set<String> checkedOutIsbns = new HashSet<>();
  private Map<String, Set<Book>> checkedOutBooksByPatron = new HashMap<>();
  private Set<String> patronIds = new HashSet<>();
  private String id;

  /**
   * Create a new library with the given id.
   *
   * @param id The id of the library.
   */
  public Library(String id) {
    this.id = id;
  }

  /**
   * Get the id of the library.
   *
   * @return The id of the library.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Add a book to the library.
   *
   * @param book The book to add.
   */
  public void addBook(Book book) {
    this.bookIds.add(book.getId());
    book.setLibrary(this);
  }

  /**
   * Remove a book from the library.
   *
   * @param book The book to remove.
   */
  public void removeBook(Book book) throws BookCheckedOutException {
    if (this.isCheckedOut(book)) {
      throw new BookCheckedOutException("Cannot remove checked out book.");
    }
    this.bookIds.remove(book.getId());
    book.setLibrary(null);
  }

  /**
   * Add a patron to the library.
   *
   * @param patron The patron to add.
   */
  public void addPatron(Patron patron) {
    this.patronIds.add(patron.getId());
    this.checkedOutBooksByPatron.put(patron.getId(), new HashSet<>());
    patron.setLibrary(this);
  }

  /**
   * Remove a patron from the library.
   *
   * @param patron The patron to remove.
   */
  public void removePatron(Patron patron) throws BookCheckedOutException {
    if (this.checkedOutBooksByPatron.get(patron.getId()).size() > 0) {
      throw new BookCheckedOutException("Cannot remove patron with checked out books.");
    }
    this.patronIds.remove(patron.getId());
    this.checkedOutBooksByPatron.remove(patron.getId());
    patron.setLibrary(null);
  }

  /**
   * Check out a book to a patron.
   *
   * @param book The book to check out.
   * @param patron The patron to check out the book to.
   * @return True if the book was checked out, false otherwise.
   */
  public boolean checkOutBook(Book book, Patron patron) {
    if (!this.canCheckOutBook(book, patron)) {
      return false;
    }
    this.checkedOutIsbns.add(book.getIsbn());
    this.checkedOutBooksByPatron.get(patron.getId()).add(book);
    return true;
  }

  private boolean canCheckOutBook(Book book, Patron patron) {
    if (!this.hasBook(book)) {
      return false;
    }
    if (this.isCheckedOut(book)) {
      return false;
    }
    if (!this.hasPatron(patron)) {
      return false;
    }
    return true;
  }

  /**
   * Check if the library has the given book.
   *
   * @param book The book to check for.
   * @return True if the library has the book, false otherwise.
   */
  public boolean hasBook(Book book) {
    return this.bookIds.contains(book.getId());
  }

  /**
   * Check if the given book is checked out.
   *
   * @param book The book to check.
   * @return True if the book is checked out, false otherwise.
   */
  public boolean isCheckedOut(Book book) {
    return this.checkedOutIsbns.contains(book.getIsbn());
  }

  /**
   * Check if the library has the given patron.
   *
   * @param patron The patron to check for.
   * @return True if the library has the patron, false otherwise.
   */
  public boolean hasPatron(Patron patron) {
    return this.patronIds.contains(patron.getId());
  }

  /**
   * Return a book to the library.
   *
   * @param book The book to return.
   * @param patron The patron returning the book.
   * @return True if the book was returned, false otherwise.
   */
  public boolean checkInBook(Book book, Patron patron) {
    if (!this.hasBook(book)) {
      return false;
    }
    this.checkedOutIsbns.remove(book.getIsbn());
    this.checkedOutBooksByPatron.get(patron.getId()).remove(book);
    return true;
  }

  /**
   * Get the books checked out by a patron.
   *
   * @param patron The patron to get the books for.
   * @return The books checked out by the patron.
   */
  public Set<Book> getCheckedOutByPatron(Patron patron) {
    return this.checkedOutBooksByPatron.get(patron.getId());
  }

  @Override
  public String toString() {
    return "Library{"
        + "bookIds="
        + bookIds
        + ", checkedOutIsbns="
        + checkedOutIsbns
        + ", checkedOutBooksByPatron="
        + checkedOutBooksByPatron
        + ", patronIds="
        + patronIds
        + '}';
  }
}
