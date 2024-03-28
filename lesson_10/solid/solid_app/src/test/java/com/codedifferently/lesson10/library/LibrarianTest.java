package com.codedifferently.lesson10.library;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibrarianTest {

  private Librarian librarian;
  private Library library;
  private Book book;

  @BeforeEach
  public void setUp() {
    librarian = new Librarian("Aaron", "Aaron@fakeemail.com");
    library = new Library("12345");
    book = new Book("Effective Java", "978-0134685991", List.of("Joshua Bloch"), 500);
  }

  @Test
  public void testAddBook() {
    librarian.addBook(library, book);
    assertTrue(library.hasBook(book));
  }

  @Test
  public void testRemoveBook() {
    librarian.addBook(library, book);
    librarian.removeBook(library, book);
    assertFalse(library.hasBook(book));
  }
}
