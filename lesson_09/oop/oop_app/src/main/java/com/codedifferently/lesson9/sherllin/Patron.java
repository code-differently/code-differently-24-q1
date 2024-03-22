package com.codedifferently.lesson9.sherllin;

public class Patron {
  private String name;
  private int bookCheckedOut;

  public Patron(String name, int bookCheckedOut) {
    this.name = name;
    this.bookCheckedOut = bookCheckedOut;
  }

  public String getName() {
    return name;
  }

  public int getBookCheckedOut() {
    return bookCheckedOut;
  }
}
