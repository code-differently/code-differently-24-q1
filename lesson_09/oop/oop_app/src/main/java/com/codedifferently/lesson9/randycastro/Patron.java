package com.codedifferently.lesson9.randycastro;

public class Patron {

  private String name;
  private String booksCheckedOut;

  // constructor
  public Patron(String name, String booksCheckedOut) {
    this.name = name;
    this.booksCheckedOut = booksCheckedOut;
  }

  // Getters and Setters
  public String getName() {
    return name;
  }

  public String getbooksCheckedOut() {
    return booksCheckedOut;
  }
}
