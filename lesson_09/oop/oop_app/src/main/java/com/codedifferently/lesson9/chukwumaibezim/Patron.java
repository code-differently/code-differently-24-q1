package com.codedifferently.lesson9.chukwumaibezim;

import java.util.HashSet;

public class Patron {
  private String name;
  private HashSet<Book> checkedOutBooks;

  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  public HashSet<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
    book.checkOut();
  }

  public void checkInBook(Book book) {
    checkedOutBooks.remove(book);
    book.checkIn();
  }
}
