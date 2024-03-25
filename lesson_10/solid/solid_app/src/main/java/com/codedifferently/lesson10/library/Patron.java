package com.codedifferently.lesson10.library;

import java.util.HashSet;
import java.util.Set;

public class Patron {
  private String name;
  private String email;
  private Set<Book> borrowedBooks;

  public Patron(String name, String email) {
    this.name = name;
    this.email = email;
    this.borrowedBooks = new HashSet<>();
  }

  public void checkOut(Book book) throws MediaNotAvailableException {
    if (book.isAvailable()) {
      borrowedBooks.add(book);
      book.setAvailable(false);
    } else {
      throw new MediaNotAvailableException("Book not available for checkout");
    }
  }

  public void checkIn(Book book) {
    borrowedBooks.remove(book);
    book.setAvailable(true);
  }

  // Getters and setters
}
