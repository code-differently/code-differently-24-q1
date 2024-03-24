package com.codedifferently.lesson9.JadasLibrary;

public class Book {
  private String title;
  private String isbn;
  private String author;
  private int numberOfPages;
  private boolean checkedOut;

  // Constructor
  public Book(String title, String isbn, String author, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.numberOfPages = numberOfPages;
    this.checkedOut = false;
  }

  // Getters and setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public boolean isCheckedOut() {
    return checkedOut;
  }

  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }
}
