package com.codedifferently.lesson10.library;

import java.util.Objects;

public class Dvd extends LibraryAsset {
  public Dvd(String title, String isbn) {
    this.title = title;
    this.isbn = isbn;
    this.canCheckOut = true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Dvd)) return false;
    Dvd dvd = (Dvd) o;
    return Objects.equals(getIsbn(), dvd.getIsbn());
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
