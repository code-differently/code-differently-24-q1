package com.codedifferently.lesson12.library;

/** Represents a DVD. */
public class Dvd extends MediaItemBase {
  public Dvd(String id, String title) {
    super(id, title);
  }

  @Override
  public String toString() {
    return "Dvd{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
