package com.codedifferently.lesson9.chukwumaibezim;

import java.util.Objects;

/** Book class */
public class Book {
  private String title;
  private String ISBN;
  private String author;
  private int numberOfPages;
  private boolean isCheckedOut;

  /**
   * Constructor for Book
   *
   * @param title
   * @param ISBN
   * @param author
   * @param numberOfPages
   */
  public Book(String title, String ISBN, String author, int numberOfPages) {
    this.title = title;
    this.ISBN = ISBN;
    this.author = author;
    this.numberOfPages = numberOfPages;
    this.isCheckedOut = false;
  }

  /**
   * Getters and Setters
   *
   * @return
   */
  public String getTitle() {
    return title;
  }

  public String getISBN() {
    return ISBN;
  }

  public String getAuthor() {
    return author;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  /**
   * Check if book is checked out
   *
   * @return
   */
  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  /** Check out book */
  public void checkOut() {
    isCheckedOut = true;
  }

  /** Check in book */
  public void checkIn() {
    isCheckedOut = false;
  }

  /**
   * Returns a string representation of the book in the format: "title by author".
   *
   * @return A string representation of the book.
   */
  @Override
  public String toString() {
    return title + " by " + author;
  }

  /**
   * Checks if two libraries are equal by comparing their books and patrons collections.
   *
   * @param obj The object to compare with this library.
   * @return True if the libraries are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Book book = (Book) obj;
    return Objects.equals(ISBN, book.ISBN);
  }

  /**
   * Generates a hash code value for the library based on its books and patrons collections.
   *
   * @return The hash code value for the library.
   */
  @Override
  public int hashCode() {
    return Objects.hash(ISBN);
  }
}
