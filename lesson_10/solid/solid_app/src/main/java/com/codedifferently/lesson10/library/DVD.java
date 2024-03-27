package com.codedifferently.lesson10.library;

public class DVD implements Media {
  private String title;
  private String type;

  public DVD(String title) {
    this.title = title;
    this.type = "DVD";
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
    // Implement logic for checking if a DVD can be checked out by a patron
    return true; // For example, DVDs can be checked out by anyone
  }
}
