package com.codedifferently.lesson9.kevinmason;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testCheckOut() {
    Book book = new Book("Title", "ISBN123", "Author", 200);
    assertFalse(book.isCheckedOut());

    book.setCheckedOut(true);
    assertTrue(book.isCheckedOut());
  }
}
