package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.ItemCantBeCheckOutException;
import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import java.util.Objects;

public class Newspaper extends LibraryAsset {

  public Newspaper(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
    this.canCheckOut = false;
  }

  @Override
  public boolean isCheckedOut() throws LibraryNotSetException {
    throw new ItemCantBeCheckOutException("This Item Cant Be Checked Out.");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Newspaper)) return false;
    Newspaper book = (Newspaper) o;
    return Objects.equals(getIsbn(), book.getIsbn());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIsbn());
  }

  @Override
  public String toString() {
    return "Item{" + "id='" + getIsbn() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
