package com.codedifferently.lesson9.mohamedibrahim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PatronTest {
  @Test
  void testPatron_create() {
    // Arrange
    var name = "Joe";
    var id = 40;

    // Act
    Patron patron = new Patron(name, id);

    // Assert
    assertEquals("Joe", patron.getName());
    assertEquals(40, patron.getId());
  }
}
