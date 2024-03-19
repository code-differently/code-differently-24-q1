package com.codedifferently.lesson9.chukwumibezim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.chukwumaibezim.Book;

public class BookTest {
  @Test
  public void testGetTitle() {
    Book book = new Book("To Kill a Mockingbird", "9780061120084", "Harper Lee", 336);
    assertEquals("To Kill a Mockingbird", book.getTitle());
  }

  @Test
  public void testGetISBN() {
    Book book =
        new Book(
            "Monster: The Autobiography of an L.A. Gang Member",
            "9780802141446",
            "Sanyika Shakur",
            400);
    assertEquals("9780802141446", book.getISBN());
  }

  @Test
  public void testGetAuthor() {
    Book book = new Book("The Art of War", "9780143037521", "Sun Tzu", 288);
    assertEquals("Sun Tzu", book.getAuthor());
  }

  @Test
  public void testGetNumberOfPages() {
    Book book = new Book("Stormbreaker (Alex Rider)", "9780142406113", "Anthony Horowitz", 240);
    assertEquals(240, book.getNumberOfPages());
  }

  @Test
  public void testIsCheckedOut() {
    Book book = new Book("Homeboyz", "9780439933497", "Alan Lawrence Sitomer", 256);
    assertFalse(book.isCheckedOut());
  }

  @Test
  public void testCheckOut() {
    Book book = new Book("Tyrell", "9780439838808", "Coe Booth", 320);
    book.checkOut();
    assertTrue(book.isCheckedOut());
  }

  @Test
  public void testCheckIn() {
    Book book = new Book("The Art of War", "9780143037521", "Sun Tzu", 288);
    book.checkOut();
    book.checkIn();
    assertFalse(book.isCheckedOut());
  }
}
