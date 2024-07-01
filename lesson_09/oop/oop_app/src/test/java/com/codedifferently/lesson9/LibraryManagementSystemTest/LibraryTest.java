package com.codedifferently.lesson9.LibraryManagementSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.LibraryManagementSystem.Book;
import com.codedifferently.lesson9.LibraryManagementSystem.Library;
import com.codedifferently.lesson9.LibraryManagementSystem.Patron;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
  private Library library;
  private Book book;
  private Patron patron;

  @BeforeEach
  public void setUp() {
    library = new Library();
    book = new Book("The Pragmatic Programmer", "9780135957059", "David Thomas, Andrew Hunt", 320);
    // Add the book to the library
    library.addBook(book);
    patron = new Patron("John Doe");
    library.registerPatron(patron);
  }

  @Test
  public void testAddBook() {
    List<Book> books = library.getBooks();
    assertEquals(1, books.size());
    assertEquals(book, books.get(0));
  }

  @Test
  public void testRemoveBook() {
    library.removeBook(book);
    List<Book> books = library.getBooks();
    assertEquals(0, books.size());
  }

  @Test
  public void testCheckOutBook() {
    library.checkOutBook(book, patron);
    assertTrue(book.isCheckedOut());
    assertTrue(patron.getCheckedOutBooks().contains(book));
  }

  @Test
  public void testReturnBook() {
    library.checkOutBook(book, patron);
    library.returnBook(book, patron);
    assertFalse(book.isCheckedOut());
    assertFalse(patron.getCheckedOutBooks().contains(book));
  }
}
