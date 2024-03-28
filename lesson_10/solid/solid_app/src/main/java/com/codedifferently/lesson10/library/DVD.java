package com.codedifferently.lesson10.library;

/** Represents a DVD */
public class DVD extends MediaItem {
  private String rating;
  private String genre;

  @Override
  public boolean canCheckOut() {
    System.out.println("Enjoy your DVD!");
    return true;
  }
}
