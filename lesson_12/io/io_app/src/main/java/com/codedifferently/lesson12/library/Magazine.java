package com.codedifferently.lesson12.library;

/** Represents a magazine. */
public class Magazine extends MediaItemBase {
  public Magazine(String id, String title) {
    super(id, title);
  }

  @Override
  public boolean canCheckOut() {
    return false;
  }

  @Override
  public String toString() {
    return "Magazine{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
