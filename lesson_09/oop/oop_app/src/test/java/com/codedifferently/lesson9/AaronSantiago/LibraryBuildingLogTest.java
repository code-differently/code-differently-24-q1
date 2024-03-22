package com.codedifferently.lesson9.AaronSantiago;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryBuildingLogTest {
  private LibraryBuildingLog library;
  private Book book1;
  private LibraryGuest guest;

  @BeforeEach
  public void setUp() {
    library = new LibraryBuildingLog();
    book1 = new Book("Harry Potter: Half-Blood Prince", "J.K. Rowling", "1122334455");
    guest = new LibraryGuest("Voldemort");

    library.addBook(book1);
    library.registerGuest(guest);
  }

  @Test
  public void testCheckOutAndReturnBook() {
    assertFalse(library.checkOutBook("NonExistentISBN", guest));
    assertTrue(library.checkOutBook(book1.getISBN(), guest));
    assertFalse(library.checkOutBook(book1.getISBN(), guest), "Book should already be checked out");

    assertTrue(library.returnBook(book1.getISBN(), guest));
    assertFalse(library.returnBook(book1.getISBN(), guest), "Book was already returned");
  }
}
