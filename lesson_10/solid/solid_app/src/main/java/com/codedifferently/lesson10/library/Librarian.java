package com.codedifferently.lesson10.library;

/** Represents a librarian in the library. */
public class Librarian extends Patron {
  private final String employeeId;

  /**
   * Creates a new librarian.
   *
   * @param name the name of the librarian
   * @param email the email of the librarian
   * @param employeeId the employee ID of the librarian
   */
  public Librarian(String name, String email, String employeeId) {
    super(name, email);
    this.employeeId = employeeId;
  }

  /**
   * Gets the employee ID of the librarian.
   *
   * @return the employee ID of the librarian
   */
  public String getEmployeeId() {
    return employeeId;
  }

  @Override
  public String toString() {
    return "Librarian{"
        + "name='"
        + getName()
        + '\''
        + ", email='"
        + getEmail()
        + '\''
        + ", employeeId='"
        + employeeId
        + '\''
        + '}';
  }
}
