package com.codedifferently.lesson9.chukwumaibezim;

import java.util.HashSet;
import java.util.Objects;

/** Patron class */
public class Patron {
  private String name;
  private HashSet<Book> checkedOutBooks;

  /**
   * Constructor for Patron
   *
   * @param name
   */
  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new HashSet<>();
  }

  /**
   * Getters and Setters
   *
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Check out book private method for Patron only
   *
   * @param book
   */
  private void checkOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  /**
   * Check in book private method for Patron only
   *
   * @param book
   */
  private void checkInBook(Book book) {
    checkedOutBooks.remove(book);
  }

  /**
   * Perform checkout public method for Library
   *
   * @param book
   */
  public void performCheckout(Book book) {
    checkOutBook(book);
  }

  /**
   * Perform check-in public method for Library
   *
   * @param book
   */
  public void performCheckIn(Book book) {
    checkInBook(book);
  }

  /**
   * Get checked out books
   *
   * @return
   */
  public HashSet<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * Checks if two libraries are equal by comparing their books and patrons collections.
   *
   * @param obj The object to compare with this library.
   * @return True if the libraries are equal, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Patron patron = (Patron) o;
    return Objects.equals(name, patron.name)
        && Objects.equals(checkedOutBooks, patron.checkedOutBooks);
  }

  /**
   * Generates a hash code value for the library based on its books and patrons collections.
   *
   * @return The hash code value for the library.
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, checkedOutBooks);
  }
}
