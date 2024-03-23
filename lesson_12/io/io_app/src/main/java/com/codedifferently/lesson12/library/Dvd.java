package com.codedifferently.lesson12.library;

import java.util.UUID;

/** Represents a DVD. */
public class Dvd extends MediaItemBase {
  public Dvd(UUID id, String title) {
    super(id, title);
  }

  @Override
  public String toString() {
    return "Dvd{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
