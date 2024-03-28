package com.codedifferently.lesson10.library;

/** Magazine */
public class Magazine extends LibraryAsset {

  public Magazine(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  @Override
  public boolean isAbleToCheckOut() {
    return false;
  }

  @Override
  public boolean isCheckedOut() {
    return false;
  }
}
