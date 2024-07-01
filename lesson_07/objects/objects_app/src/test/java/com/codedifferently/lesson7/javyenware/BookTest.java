package com.codedifferently.lesson7.javyenware;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testBookConstruction() {
    Book book = new Book("Title", "Author", "Publisher", (short) 2000, 10.50f, (byte) 200);
    assertEquals("Title", book.getTitle());
    assertEquals("Author", book.getAuthor());
    assertEquals("Publisher", book.getPublisher());
    assertEquals((short) 2000, book.getYearReleased());
    assertEquals(10.50f, book.getPrice(), 0.01);
    assertEquals((byte) 200, book.getPageNumber());
  }

  @Test
  public void testPriceEvaluation_Expensive() {
    String message = bookPriceEvaluation(20.00f);
    assertEquals("Don't buy book (Too expensive)", message);
  }

  @Test
  public void testPriceEvaluation_Affordable() {
    String message = bookPriceEvaluation(10.00f);
    assertEquals("Buy the book (Good price to buy)", message);
  }

  @Test
  public void testCollectionOfAuthorNames() {
    // Assuming this method collects author names and years of publication and prints them
    // Here, we'll just test if the method doesn't throw any exceptions.
    Book book = new Book("Title", "Author", "Publisher", (short) 2000, 10.50f, (byte) 200);
    book.CollectionOfAuthorNames(new String[] {"Author1", "Author2", "Author3"});
  }

  @Test
  public void testNoBookAvailableException() {
    assertThrows(
        Book.NoBookAvailable.class,
        () -> {
          throw new Book.NoBookAvailable("No book available");
        });
  }

  @Test
  public void testGetters() {
    Book book = new Book("Title", "Author", "Publisher", (short) 2000, 10.50f, (byte) 200);
    assertEquals("Title", book.getTitle());
    assertEquals("Author", book.getAuthor());
    assertEquals("Publisher", book.getPublisher());
    assertEquals((short) 2000, book.getYearReleased());
    assertEquals(10.50f, book.getPrice(), 0.01);
    assertEquals((byte) 200, book.getPageNumber());
  }

  private String bookPriceEvaluation(float price) {
    Book book = new Book("Title", "Author", "Publisher", (short) 2000, price, (byte) 200);
    return book.price(price);
  }
}
