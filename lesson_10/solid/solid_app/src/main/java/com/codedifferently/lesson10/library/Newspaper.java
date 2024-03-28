package com.codedifferently.lesson10.library;

public class Newspaper extends MediaItem {
  private String title;

  @Override
  public boolean canCheckOut() {
    System.out.print("This item cannot be checked out.");
    return false;
  }
}
