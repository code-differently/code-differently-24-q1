package com.codedifferently.lesson9.JadasLibraryTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.JadasLibrary.Book;
import com.codedifferently.lesson9.JadasLibrary.Patron;
import org.junit.jupiter.api.Test;

public class JadaslibraryTest {

  @Test
  public void testAddBookToLibrary() {
    Library library = new Library();
    Book book = new Book("The Bluest Eye", "978-0140088298", "Toni Morrison", 226);
    library.addBook(book);
    assertTrue(library.getBooks().contains(book));
  }

  @Test
  public void testRemoveBookFromLibrary() {
    Library library = new Library();
    Book book = new Book("Sula", "978-0452260108", "Toni Morrison", 193);
    library.addBook(book);
    library.removeBook(book);
    assertFalse(library.getBooks().contains(book));
  }

  @Test
  public void testRegisterPatron() {
    Library library = new Library();
    Patron patron = new ConcretePatronTest("Stacy Law");
    library.registerPatron(patron);
    assertTrue(library.getPatrons().contains(patron));
  }

  @Test
  public void testCheckOutBook() {
    Library library = new Library();
    Book book = new Book("Liden Hills", "978-3293006853", "Gloria Naylor", 320);
    Patron patron = new ConcretePatronTest("Clay Brown");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(book, patron);
    assertFalse(patron.getCheckedOutBooks().contains(book));
    assertTrue(book.isCheckedOut());
  }

  @Test
  public void testReturnBook() {
    Library library = new Library();
    Book book = new Book("Nobody Knows My Name", "978-0679744733", "James Baldwin", 256);
    Patron patron = new ConcretePatronTest("Bob Willson");
    library.addBook(book);
    library.registerPatron(patron);
    library.checkOutBook(book, patron);
    library.returnBook(book, patron);
    assertFalse(patron.getCheckedOutBooks().contains(book));
    assertFalse(book.isCheckedOut());
  }
}
