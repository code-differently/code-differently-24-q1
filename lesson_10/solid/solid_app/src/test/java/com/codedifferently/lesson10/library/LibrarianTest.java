package com.codedifferently.lesson10.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LibrarianTest {

  @Test
  void testLibrarianCreation() {
    // Arrange
    String name = "Jermine Cole";
    String email = "jcole@gmail.com";
    String employeeId = "9900-edu";

    // Act
    Librarian librarian = new Librarian(name, email, employeeId);

    // Assert
    assertNotNull(librarian);
    assertEquals(name, librarian.getName());
    assertEquals(email, librarian.getEmail());
    assertEquals(employeeId, librarian.getEmployeeId());
  }

  @Test
  void testToString() {
    // Arrange
    String name = "Jermine Cole";
    String email = "jcole@gmail.com";
    String employeeId = "9900-edu";
    Librarian librarian = new Librarian(name, email, employeeId);

    // Act
    String toStringResult = librarian.toString();

    // Assert
    String expectedToString =
        "Librarian{name='Jermine Cole', email='jcole@gmail.com', employeeId='9900-edu'}";
    assertEquals(expectedToString, toStringResult);
  }
}
