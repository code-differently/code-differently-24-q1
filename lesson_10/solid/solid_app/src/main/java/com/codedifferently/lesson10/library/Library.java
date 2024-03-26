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
   * @throws BookCheckedOutException If the book is checked out.
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
   * @throws BookCheckedOutException If the patron has checked out books.
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

  /**
   * Check in a book from a patron.
   *
   * @param book The book to check in.
   * @param patron The patron to check in the book from.
   * @return True if the book was checked in, false otherwise.
   */
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
   * @param book The book to check for.
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
   * Check in a book from a patron.
   *
   * @param book The book to check in.
   * @param patron The patron to check in the book from.
   * @return True if the book was checked in, false otherwise.
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
   * Get the books currently checked out by a patron.
   *
   * @param patron The patron to get the books for.
   * @return The books currently checked out by the patron.
   */
  public Set<Book> getCheckedOutByPatron(Patron patron) {
    return this.checkedOutBooksByPatron.get(patron.getId());
  }

  /**
   * Check out a book to a librarian.
   *
   * @param book The book to check out.
   * @param librarian The librarian to check out the book to.
   * @return True if the book was checked out, false otherwise.
   */
  public boolean CheckOutMedia(Book item, Librarian librarian) {
    if (canCheckOutMedia(item, librarian)) {
      if (!checkedOutIsbns.contains(item.getIsbn())) {
        checkedOutIsbns.add(item.getIsbn());
        Set<Book> checkedOutBooks =
            checkedOutBooksByPatron.getOrDefault(librarian.getId(), new HashSet<>());
        checkedOutBooks.add(item);
        checkedOutBooksByPatron.put(librarian.getId(), checkedOutBooks);
        return true;
      } else {
        System.out.println("This item is already checked out.");
        return false;
      }
    } else {
      System.out.println("You are not allowed to check out this item.");
      return false;
    }
  }

  /**
   * Check in a book from a librarian.
   *
   * @param book The book to check in.
   * @param librarian The librarian to check in the book from.
   * @return True if the book was checked in, false otherwise.
   */
  public boolean CheckInMedia(Book item, Librarian librarian) {
    if (checkedOutIsbns.contains(item.getIsbn())) {
      checkedOutIsbns.remove(item.getIsbn());
      Set<Book> checkedOutBooks =
          checkedOutBooksByPatron.getOrDefault(librarian.getId(), new HashSet<>());
      checkedOutBooks.remove(item);
      checkedOutBooksByPatron.put(librarian.getId(), checkedOutBooks);
      return true;
    } else {
      System.out.println("This item is not currently checked out.");
      return false;
    }
  }

  /**
   * Check if a librarian is registered in the library.
   *
   * @param librarian The librarian to check for.
   * @return True if the librarian is registered in the library, false otherwise.
   */
  public boolean canCheckOutMedia(MediaItem item, Librarian librarian) {
    if (!hasPatron(librarian)) {
      System.out.println("Librarian is not registered in the library.");
      return false;
    }

    if (!checkedOutBooksByPatron.containsKey(librarian.getId())) {
      checkedOutBooksByPatron.put(librarian.getId(), new HashSet<>());
    }

    if (item instanceof Book) {
      Book book = (Book) item;
      if (!hasBook(book)) {
        System.out.println("The library does not have this book.");
        return false;
      }
      if (isCheckedOut(book)) {
        System.out.println("The book is already checked out.");
        return false;
      }
      return true;
    } else {
      System.out.println("This library only supports checking out books.");
      return false;
    }
  }

  /**
   * Check if a librarian is registered in the library.
   *
   * @param librarian The librarian to check for.
   * @return True if the librarian is registered in the library, false otherwise.
   */
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
