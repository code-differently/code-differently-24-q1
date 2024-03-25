package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;

public class Librarian {

  public void checkOutBook(Book book, Patron patron) throws BookCheckedOutException {
    if (book.isCheckedOut()) {
      throw new BookCheckedOutException("Book is already checked out.");
    }
    book.setLibrary(null);
    book.setLibrary(patron.getLibrary());
    patron.getLibrary().checkOutBook(book, patron);
  }

  public void checkInBook(Book book, Patron patron) throws BookCheckedOutException {
    if (!patron.getLibrary().isCheckedOut(book)) {
      throw new BookCheckedOutException("Book is not checked out.");
    }
    patron.getLibrary().checkInBook(book, patron);
    book.setLibrary(null);
  }
}
