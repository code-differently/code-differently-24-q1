package com.codedifferently.lesson10.library;

import java.util.UUID;

/** Represents a DVD in the library. */
class DVD extends MediaItem {

  /**
   * Creates a new DVD.
   *
   * @param title the title of the DVD
   * @param author the author of the DVD
   */
  public DVD(String title, String author) {
    super(UUID.randomUUID(), title, "DVD");
  }
}
