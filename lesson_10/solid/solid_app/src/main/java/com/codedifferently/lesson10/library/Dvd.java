package com.codedifferently.lesson10.library;

public class Dvd extends LibraryAsset {
  public Dvd(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
    this.library = library;
    this.canCheckOut = true;
  }
}
