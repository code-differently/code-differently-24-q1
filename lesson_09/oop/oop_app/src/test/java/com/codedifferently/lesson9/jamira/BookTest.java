package com.codedifferently.lesson9.jamira;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testConstructorAndGetters() {
    Book book = new Book("Title", "ISBN123", List.of("author"), 200, false);
    assertEquals("Title", book.getTitle());
    assertEquals("ISBN123", book.getIsbn());
    assertEquals(List.of("author"), book.getAuthors());
    assertEquals(200, book.getNumPages());
    assertFalse(book.isCheckedOut());
  }

  @Test
  public void testSetters() {
    Book java = new Book("Title", "ISBN123", List.of("author"), 200, false);
    java.setTitle("Title2");
    java.setIsbn("ISBN456");
    java.setAuthors(List.of("authors"));
    java.setNumPages(300);
    java.setCheckedOut(false);
    assertEquals("Title2", java.getTitle());
    assertEquals("ISBN456", java.getIsbn());
    assertEquals(List.of("authors"), java.getAuthors());
    assertEquals(300, java.getNumPages());
    assertFalse(java.isCheckedOut());
  }
}
