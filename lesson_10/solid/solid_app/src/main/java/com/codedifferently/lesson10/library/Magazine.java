package com.codedifferently.lesson10.library;

/** Represents a Magazine */
public class Magazine extends MediaItem {
  private String title;

  /**
   * Get the id of the book.
   *
   * @return The id of the book.
   */
  @Override
  public String getId() {
    return this.title;
  }

  @Override
  public boolean canOrCantCheckOut() {
    System.out.print("This item cannot be checked out.");
    return false;
  }
}
