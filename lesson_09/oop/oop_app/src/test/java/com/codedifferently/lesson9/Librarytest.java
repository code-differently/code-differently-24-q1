package com.codedifferently.lesson9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson9.KyvonThompsonlesson09.Book;
import org.junit.jupiter.api.Test;

public class Librarytest {
  private Library library;
  private Book book;
  private Patron patron;

  @Before
  public void setUp() {
    library = new Library();
    book = new Book(true, "Frank Miller", "The Dark Knight Returns", 250, (float) 18.9595);
    library.addBook(book);
    patron = new Patron("John Doe");
    library.registerPatron(patron);
  }

  @Test
  public void testAddBook() {
    assertEquals(1, library.getBooks().size());
    assertEquals(book, library.getBooks().get(0));
  }

  @Test
  public void testRemoveBook() {
    library.removeBook(book);
    assertEquals(0, library.getBooks().size());
  }

  @Test
  public void testCheckOutBook() {
    library.checkOutBook(patron, book);
    assertTrue(book.getCheckedOut());
    assertTrue(patron.getCheckedOutBooks().contains(book));
  }

  private void assertTrue(boolean contains) {
    throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
  }

  @Test
  public void testReturnBook() {
    library.checkOutBook(patron, book);
    library.returnBook(patron, book);
    assertFalse(book.getCheckedOut());
    assertFalse(patron.getCheckedOutBooks().contains(book));
  }

  private void assertFalse(Boolean checkedOut) {
    throw new UnsupportedOperationException("Unimplemented method 'assertFalse'");
  }
}
