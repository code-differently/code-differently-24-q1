package com.codedifferently.lesson10.library;

public class Magazine implements Media {
  private String title;
  private String type;

  public Magazine(String title) {
    this.title = title;
    this.type = "Magazine";
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
    // Implement logic for checking if a magazine can be checked out by a patron
    return false; // Magazines cannot be checked out
  }
}
