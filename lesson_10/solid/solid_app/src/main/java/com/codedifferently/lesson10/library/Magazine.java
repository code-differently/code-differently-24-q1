package com.codedifferently.lesson10.library;

import java.util.UUID;

/** Represents a magazine in the library. */
class Magazine extends MediaItem {

  /**
   * Creates a new magazine.
   *
   * @param title the title of the magazine
   * @param author the author of the magazine
   */
  public Magazine(String title, String author) {
    super(UUID.randomUUID(), title, "Magazine");
  }
}
