package com.codedifferently.lesson10.library;

public class Newspaper extends MediaItem {
  private String headline;

  /**
   * Get the id of the newspaper.
   *
   * @return The id of the newspaper.
   */
  @Override
  public String getId() {
    return this.headline;
  }

  @Override
  public boolean canOrCantCheckOut() {
    System.out.print("This item cannot be checked out.");
    return false;
  }
}
