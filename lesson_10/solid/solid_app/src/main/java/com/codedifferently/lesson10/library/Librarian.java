package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;

/** Represents a librarian of a library. */
public class Librarian extends Patron {

  /**
   * Create a new librarian with the given name and email.
   *
   * @param name The name of the librarian.
   * @param email The email of the librarian.
   */
  public Librarian(String name, String email) {
    super(name, email);
  }

  /**
   * Check out a book to a patron.
   *
   * @param book The book to check out.
   * @return True if the book was checked out, false otherwise.
   */
  @Override
  public boolean checkOutBook(Book book) {
    if (this instanceof Librarian) {
      return super.checkOutBook(book);
    }
    return false; // Librarians cannot check out books to regular patrons
  }

  /**
   * Return a book to the library.
   *
   * @param book The book to return.
   * @return True if the book was returned, false otherwise.
   */
  @Override
  public boolean checkInBook(Book book) {
    if (this instanceof Librarian) {
      return super.checkInBook(book);
    }
    return false; // Librarians cannot return books for regular patrons
  }

  /**
   * Remove a book from the library.
   *
   * @param book The book to remove.
   */
  public void removeBook(Book book) throws BookCheckedOutException {
    if (book.isCheckedOut()) {
      throw new BookCheckedOutException("Cannot remove checked out book.");
    }
    book.setLibrary(null);
  }
}
