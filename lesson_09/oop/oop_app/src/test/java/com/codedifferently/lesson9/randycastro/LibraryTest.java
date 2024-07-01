package com.codedifferently.lesson9.randycastro;

import org.junit.jupiter.api.Test;

public class LibraryTest {
  @Test
  public void testGetBookByISBN() {
    Library library = new Library();

    Book retrievedBook1 = library.getBookByISBN("12345e");
  }
}
