package com.codedifferently.lesson10.library;

public class Librarian extends Patron {

  private String employeeId;

  public Librarian(String name, String employeeId) {
    super();
    this.name = name;
    this.employeeId = employeeId;
  }

  public String getEmployeeId() {
    return employeeId;
  }
}
