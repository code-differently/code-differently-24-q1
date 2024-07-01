package com.codedifferently.lesson9.JadasLibrary;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class JadaslibraryTest {

  @Test
  public void testAddBookToLibrary() {
    Jadaslibrary library = new Jadaslibrary();
    Book book = new Book("The Bluest Eye", "978-0140088298", "Toni Morrison", 226);
    library.addBook(book);
    assertTrue(library.getBooks().contains(book));
  }

  @Test
  public void testRemoveBookFromLibrary() {
    Jadaslibrary library = new Jadaslibrary();
    Book book = new Book("Sula", "978-0452260108", "Toni Morrison", 193);
    library.addBook(book);
    library.removeBook(book);
    assertFalse(library.getBooks().contains(book));
  }

  @Test
  public void testRegisterPatron() {
    Jadaslibrary library = new Jadaslibrary();
    Patron patron = new PatronImpl("Stacy Law");
    library.registerPatron(patron);
    assertTrue(library.getPatrons().contains(patron));
  }

  @Test
  public void testCheckOutBook() {
    Jadaslibrary library = new Jadaslibrary();
    Book book = new Book("Liden Hills", "978-3293006853", "Gloria Naylor", 320);
    Patron patron = new PatronImpl("Clay Brown");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(book, patron);
    assertTrue(patron.getCheckedOutBooks().contains(book));
    assertTrue(book.isCheckedOut());
  }

  @Test
  public void testReturnBook() {
    Jadaslibrary library = new Jadaslibrary();
    Book book = new Book("Nobody Knows My Name", "978-0679744733", "James Baldwin", 256);
    Patron patron = new PatronImpl("Bob Willson");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(book, patron);
    library.returnBook(book, patron);
    assertFalse(patron.getCheckedOutBooks().contains(book));
    assertFalse(book.isCheckedOut());
  }
}
