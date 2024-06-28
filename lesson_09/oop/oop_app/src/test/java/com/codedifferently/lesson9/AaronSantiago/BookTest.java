package com.codedifferently.lesson9.AaronSantiago;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testBookDetails() {
    Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", "123456789");
    assertEquals("The Great Gatsby", book.getTitle());
    assertEquals("F. Scott Fitzgerald", book.getAuthor());
    assertEquals("123456789", book.getISBN());
  }
}
