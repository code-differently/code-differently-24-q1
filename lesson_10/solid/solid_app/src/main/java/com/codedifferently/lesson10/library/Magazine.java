package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.*;
import java.util.Objects;

/** Magazine */
public class Magazine extends LibraryAsset {

  Magazine(String title, String isbn) {
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
    if (!(o instanceof Magazine)) return false;
    Magazine book = (Magazine) o;
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
