package com.codedifferently.lesson9.chukwumaibezim;

import java.util.HashSet;

/**
 * Patron class
 */
public class Patron {
  private String name;
  private HashSet<Book> checkedOutBooks;

  /**
   * Constructor for Patron
   * @param name
   */
  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new HashSet<>();
  }

  /**
   * Getters and Setters
   * @return
   */
  public String getName() {
    return name;
  }

  public HashSet<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * Check out book
   * @param book
   */
  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
    book.checkOut();
  }

  /**
   * Check in book
   * @param book
   */
  public void checkInBook(Book book) {
    checkedOutBooks.remove(book);
    book.checkIn();
  }
}
