package com.codedifferently.lesson9.chukwumaibezim;

public class Book {
  private String title;
  private String ISBN;
  private String author;
  private int numberOfPages;
  private boolean isCheckedOut;

  public Book(String title, String ISBN, String author, int numberOfPages) {
    this.title = title;
    this.ISBN = ISBN;
    this.author = author;
    this.numberOfPages = numberOfPages;
    this.isCheckedOut = false;
  }

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

  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  public void checkOut() {
    isCheckedOut = true;
  }

  public void checkIn() {
    isCheckedOut = false;
  }

  public String toString() {
    return title + " by " + author;
  }

  public boolean equals(Object obj) {
    if (obj instanceof Book) {
      Book other = (Book) obj;
      return this.ISBN.equals(other.ISBN);
    }
    return false;
  }

  public int hashCode() {
    return ISBN.hashCode();
  }
}
