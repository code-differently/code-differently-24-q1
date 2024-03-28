package com.codedifferently.lesson10.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class LibrarianTest {

  @Test
  void testLibrarianCreation() {
    // Arrange
    String name = "Alice";
    String email = "alice@example.com";
    Library library = new Library("Library 1");

    // Act
    Librarian librarian = new Librarian(name, email, library);

    // Assert
    assertNotNull(librarian);
    assertEquals(name, librarian.getName());
    assertEquals(email, librarian.getId());
    assertEquals(library, librarian.getLibrary());
  }
}
