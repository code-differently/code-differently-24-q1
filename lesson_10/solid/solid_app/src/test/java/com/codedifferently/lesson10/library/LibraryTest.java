package com.codedifferently.lesson10.library;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
  private Library library;

  @BeforeEach
  void setUp() {
    library = new Library();
    library.setLibrarian(new Librarian("Jermaine Cole", "jcole@gmail.com", "9900-edu"));
  }

  @Test
  public void testAddMediaItem() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    library.addMediaItem(book);

    assertTrue(library.hasMediaItem(book));
  }

  @Test
  public void testRemoveMediaItem() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    library.addMediaItem(book);

    assertTrue(library.hasMediaItem(book));

    library.removeMediaItem(book);

    assertFalse(library.hasMediaItem(book));
  }

  @Test
  public void testAddPatron() {
    Patron patron = new Patron("Curtis", "Jackson");
    library.addPatron(patron);

    assertTrue(library.hasPatron(patron));
  }

  @Test
  public void testRemovePatron() throws MediaItemCheckedOutException {
    Patron patron = new Patron("Curtis", "Jackson");
    library.addPatron(patron);

    assertTrue(library.hasPatron(patron));

    library.removePatron(patron);

    assertFalse(library.hasPatron(patron));
  }

  @Test
  public void testCheckoutMediaItem() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    Patron patron = new Patron("Curtis", "Jackson");

    library.addMediaItem(book);
    library.addPatron(patron);

    assertTrue(library.checkOutMediaItem(book, patron));
    assertTrue(library.isCheckedOut(book));
  }

  @Test
  public void testSearchByType() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    DVD dvd = new DVD(UUID.randomUUID().toString(), "The Color Purple"); // Convert UUID to String

    library.addMediaItem(book);
    library.addMediaItem(dvd);

    List<MediaItem> foundBooks = library.searchByType("book");
    List<MediaItem> foundDVDs = library.searchByType("dvd");

    assertEquals(1, foundBooks.size());
    assertEquals(1, foundDVDs.size());
  }

  @Test
  public void testSearchByISBN() {
    Book book1 =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    Book book2 =
        new Book(
            UUID.randomUUID(), "The Color Purple", List.of("Alice Walker"), 1982, "9780151191543");

    library.addMediaItem(book1);
    library.addMediaItem(book2);

    assertEquals(book1, library.searchByISBN("9780802141446"));
    assertEquals(book2, library.searchByISBN("9780151191543"));
  }

  @Test
  public void testSearchByAuthor() {
    Book book1 =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    Book book2 =
        new Book(
            UUID.randomUUID(), "The Color Purple", List.of("Alice Walker"), 1982, "9780151191543");
    Book book3 =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");

    library.addMediaItem(book1);
    library.addMediaItem(book2);
    library.addMediaItem(book3);

    List<MediaItem> foundBooks1 = library.searchByAuthor("Sanyika Shakur");
    List<MediaItem> foundBooks2 = library.searchByAuthor("Alice Walker");

    assertEquals(2, foundBooks1.size());
    assertEquals(1, foundBooks2.size());
  }

  @Test
  public void testSearchByUUID() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    library.addMediaItem(book);

    MediaItem foundItem = library.searchByUUID(book.getUUID());

    assertEquals(book, foundItem);
  }

  @Test
  public void testSearchByTitle() {
    Book book1 =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    Book book2 =
        new Book(
            UUID.randomUUID(), "The Color Purple", List.of("Alice Walker"), 1982, "9780151191543");

    library.addMediaItem(book1);
    library.addMediaItem(book2);

    assertEquals(book1, library.searchByTitle("Monster: The Autobiography of an L.A. Gang Member"));
    assertEquals(book2, library.searchByTitle("The Color Purple"));
  }

  @Test
  public void testHasBook() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    library.addMediaItem(book);

    assertTrue(library.hasBook(book));
  }

  @Test
  public void testGetCheckedOutByPatron() {
    Book book =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "9780802141446");
    Patron patron = new Patron("Curtis", "Jackson");

    library.addMediaItem(book);
    library.addPatron(patron);

    library.checkOutMediaItem(book, patron);

    Set<MediaItem> checkedOutItems = library.getCheckedOutByPatron(patron);

    assertEquals(1, checkedOutItems.size());
    assertTrue(checkedOutItems.contains(book));
  }

  @Test
  public void testPatronWithMultipleLibraries() {

    Library library1 = new Library();
    Library library2 = new Library();

    Librarian librarian = new Librarian("Jermaine Cole", "jcole@gmail.com", "9900-edu");

    library1.setLibrarian(librarian);
    library2.setLibrarian(librarian);

    Patron patron = new Patron("Curtis", "Jackson");

    library1.addPatron(patron);
    library2.addPatron(patron);

    assertTrue(library1.hasPatron(patron));
    assertTrue(library2.hasPatron(patron));
  }
}
