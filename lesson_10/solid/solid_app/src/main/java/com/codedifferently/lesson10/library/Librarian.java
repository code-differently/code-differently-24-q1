package com.codedifferently.lesson10.library;

public class Librarian implements Member {

  @Override
  public void checkOutBook() {
    System.out.println("Librarian is checking the book out");
  }

  public void returnBook() {
    System.out.println("Librarian is returning book");
  }
}
