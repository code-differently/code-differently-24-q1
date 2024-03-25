package com.codedifferently.lesson10.library;

/** Represents a Magazine */
public class Magazine extends MediaItem {
  private String title;

  @Override
  public boolean canCheckOut() {
    System.out.print("This item cannot be checked out.");
    return false;
  }
}
