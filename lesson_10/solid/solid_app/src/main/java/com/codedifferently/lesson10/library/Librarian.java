package com.codedifferently.lesson10.library;

public class Librarian extends Patron {
  public void checkOutBook(Book book, Patron patron, Library library)
      throws BookCheckedOutException {
    if (!book.isAvailable()) {
      throw new BookCheckedOutException("Book is already checked out");
    }
    book.setAvailable(false);
    patron.addBook(book);
  }

  public void checkInBook(Book book, Patron patron, Library library) {
    book.setAvailable(true);
    patron.removeBook(book);
  }
}
