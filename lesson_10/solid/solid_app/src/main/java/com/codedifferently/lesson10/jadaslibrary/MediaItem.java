package com.codedifferently.lesson10.jadaslibrary;

public class MediaItem {
  private String title;
  private String isbn;
  private int numberOfPages;
  private boolean isCheckedOut;
  private Patron patron;

  public MediaItem(String title, String isbn, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.numberOfPages = numberOfPages;
    this.isCheckedOut = false;
    this.patron = null;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  public void setCheckedOut(boolean checkedOut) {
    this.isCheckedOut = checkedOut;
  }

  public Patron getPatron() {
    return patron;
  }

  public void setPatron(Patron patron) {
    this.patron = patron;
  }
}
