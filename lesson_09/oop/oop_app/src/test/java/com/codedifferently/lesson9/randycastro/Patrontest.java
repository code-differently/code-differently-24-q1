package com.codedifferently.lesson9.randycastro;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Patrontest {

  @Test
  // testing patron
  // Arange
  public void testPatron() {
    String name = "Randy";
    String booksCheckedOut = "Code Complete";
    // Act

    Patron patron = new Patron(name, booksCheckedOut);
    // Asserts
    assertEquals(name, patron.getName());
    assertEquals(booksCheckedOut, patron.getbooksCheckedOut());
  }
}
