package com.codedifferently.lesson9.natayaprice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testConstructor() {
    Book book = new Book("Title", 1234567890, "Author", 200, false);
    assertEquals("Title", book.getTitles());
        assertEquals(1234567890, book.getISBN());
        assertEquals("Author", book.getAuthors());
        assertEquals(200, book.getTotalPages());
        assertFalse(book.getCheckedOut()); 
  }



  @Test
  public void testGetTitle() {
    Book book = new Book("Children of Blood and Bone",972, "Tomi Adeyemi", 544, false);
    assertEquals("Children of Blood and Bone", book.getTitles());
  }

  @Test
  public void testGetISBN() {
    Book book =
        new Book(
            "The Sisters Grimm:The Fairy-Tale Detectives",571, "Michael Buckley", 176,true);
    assertEquals("9780810970571", book.getISBN());
  }

  @Test
  public void testGetAuthors() {
    Book book = new Book("A Light in the Attic",739, "Shel Silverstein", 176,true);
    assertEquals("Shel Silverstein", book.getAuthors());
  }

  @Test
  public void testGetTotalPages() {
    Book book =
        new Book(
            "Junie B. Jones and the Mushy Gushy Valentine",408, "Barbara Park", 80,true);
    assertEquals(80, book.getTotalPages());
  }

  @Test
  public void testGetCheckedOut() {
    Book book =
        new Book(
            "Thirst: Human Urges, Fatal Consequences", 060, "Michael Farquhar", 384,false);
    assertFalse(book.getCheckedOut());
  }

  @Test
  public void testIsCheckedOut() {
    Book book =
        new Book("Women Who Run with the Wolves",874, "Clarissa Pinkola Estés", 560,true);
      assertTrue(book.getCheckedOut());
  }

  @Test
  public void testGetCheckedIn() {
    Book book = new Book("Beloved",416, "Toni Morrison", 324,false);
    assertFalse(book.getCheckedOut());
  }
}
