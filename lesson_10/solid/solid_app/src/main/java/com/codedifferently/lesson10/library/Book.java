package com.codedifferently.lesson10.library;

public class Book extends Media {
  private boolean available;
  private String ISBN;

  public Book(String ISBN) {
    this.ISBN = ISBN;
    this.available = true; // Assuming all books are initially available
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String getISBN() {
    return ISBN;
  }

  // Implementing the checkIn method from the Media class
  @Override
  public void checkIn(Patron borrower, Library library) {
    // Implement book check-in logic here
    // For example:
    // Mark the book as available
    this.available = true;
  }
}
