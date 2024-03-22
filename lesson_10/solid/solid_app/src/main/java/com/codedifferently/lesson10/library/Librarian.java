package com.codedifferently.lesson10.library;

public class Librarian extends Patron {
  int employeeId;

  public Librarian(String name, Library library, String email, int employeeId) {
    super(name, email, library);
    this.employeeId = employeeId;
  }
}
