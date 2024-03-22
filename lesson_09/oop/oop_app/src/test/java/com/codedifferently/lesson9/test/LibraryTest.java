package com.codedifferently.lesson9.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.library.Book;
import com.codedifferently.lesson9.library.Library;
import com.codedifferently.lesson9.library.Patron;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
  private Library library;
  private Book comic;
  private Patron patron;

  @BeforeEach
  public void setup() {
    library = new Library();
    comic = new Book("X-Men", "9781302921785", List.of("Stan Lee"), 250);
    patron = new Patron("Natasha Romanoff");
  }

  @Test
  public void testAddComic() {
    library.addComic(comic);
    assertEquals(1, library.getMarvelComics().size());
    assertTrue(library.getMarvelComics().contains(comic));
  }

  @Test
  public void testRemoveComic() {
    library.addComic(comic);
    assertEquals(1, library.getMarvelComics().size());
    library.removeComic(comic);
    assertEquals(0, library.getMarvelComics().size());
  }

  @Test
  public void testRegisterPatron() {
    library.registerPatron(patron);
    assertEquals(1, library.getPatrons().size());
    assertTrue(library.getPatrons().contains(patron));
  }

  @Test
  public void testCheckOutComic() {
    library.addComic(comic);
    library.registerPatron(patron);
    library.checkOutComic(comic, patron);
    assertEquals(1, patron.getCheckedOutBooks().size());
    assertTrue(patron.getCheckedOutBooks().contains(comic));
  }
}
