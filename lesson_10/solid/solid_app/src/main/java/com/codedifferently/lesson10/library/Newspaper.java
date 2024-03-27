package com.codedifferently.lesson10.library;

import java.util.UUID;

/** Represents a Newspaper class */
class Newspaper extends MediaItem {

  /** Creates a new newspaper */
  public Newspaper(String title, String author) {
    super(UUID.randomUUID(), title, "Newspaper");
  }
}
