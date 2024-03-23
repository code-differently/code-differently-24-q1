package com.codedifferently.lesson12.library;

/** Represents a newspaper. */
public class Newspaper extends MediaItemBase {
  public Newspaper(String id, String title) {
    super(id, title);
  }

  @Override
  public boolean canCheckOut() {
    return false;
  }

  @Override
  public String toString() {
    return "Newspaper{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
