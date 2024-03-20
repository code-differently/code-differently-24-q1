package com.codedifferently.lesson9.natayaprice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testGetTitle() {
    Book book = new Book("Children of Blood and Bone", "781250170972", "Tomi Adeyemi", 544);
    assertEquals("Children of Blood and Bone", book.getTitle());
  }

  @Test
  public void testGetISBN() {
    Book book =
        new Book(
            "The Sisters Grimm:The Fairy-Tale Detectives", "9780810970571", "Michael Buckley", 176);
    assertEquals("9780810970571", book.getISBN());
  }

  @Test
  public void testGetAuthors() {
    Book book = new Book("A Light in the Attic", "9780060256739", "Shel Silverstein", 176);
    assertEquals("Shel Silverstein", book.getAuthors());
  }

  @Test
  public void testGetTotalPages() {
    Book book =
        new Book(
            "Junie B. Jones and the Mushy Gushy Valentine", "9780375800408", "Barbara Park", 80);
    assertEquals(80, book.getTotalPages());
  }

  @Test
  public void testGetCheckedOut() {
    Book book =
        new Book(
            "Thirst: Human Urges, Fatal Consequences", "9780307237060", "Michael Farquhar", 384);
    assertFalse(book.getCheckedOut());
  }

  @Test
  public void testIsCheckedOut() {
    Book book =
        new Book("Women Who Run with the Wolves", "9780345409874", "Clarissa Pinkola Estés", 560);
    book.checkOut();
    assertTrue(book.getCheckedOut());
  }

  @Test
  public void testGetCheckedIn() {
    Book book = new Book("Beloved", "9781400033416", "Toni Morrison", 324);
    book.checkIn();
    book.checkOut();
    assertFalse(book.getCheckedOut());
  }
}
