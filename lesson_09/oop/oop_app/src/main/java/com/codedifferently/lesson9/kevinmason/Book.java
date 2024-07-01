package com.codedifferently.lesson9.kevinmason;

public class Book {
  private String title;
  private String isbn;
  private String author;
  private int numberOfPages;
  private boolean checkedOut;

  public Book(String title, String isbn, String author, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.numberOfPages = numberOfPages;
    this.checkedOut = false;
  }

  public String getTitle() {
    return title;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getAuthor() {
    return author;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public boolean isCheckedOut() {
    return checkedOut;
  }

  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }
}
