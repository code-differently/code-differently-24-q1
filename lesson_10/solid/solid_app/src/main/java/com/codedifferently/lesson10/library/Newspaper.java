package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.ItemCantBeCheckOutException;
import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;

public class Newspaper extends LibraryAsset {

  public Newspaper(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
  }

  @Override
  public boolean isAbleToCheckOut() {
    return false;
  }

  @Override
  public boolean isCheckedOut() throws LibraryNotSetException {
    throw new ItemCantBeCheckOutException("This Item Cant Be Checked Out.");
  }
}
