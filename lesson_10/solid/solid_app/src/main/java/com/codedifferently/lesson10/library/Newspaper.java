package com.codedifferently.lesson10.library;

public class Newspaper implements Media {
  private String title;
  private String type;

  public Newspaper(String title) {
    this.title = title;
    this.type = "Newspaper";
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public boolean canBeCheckedOutBy(Patron patron) {
    // Implement logic for checking if a newspaper can be checked out by a patron
    return false; // Newspapers cannot be checked out
  }
}
