package com.codedifferently.lesson9.library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryGuestTest {
  private Book book1;
  private LibraryGuest guest;

  @BeforeEach
  public void setUp() {
    book1 = new Book("No Man's Land", "Greg Rucka", "987654321");
    guest = new LibraryGuest("Batman");
  }

  @Test
  public void testCheckOutAndReturnBook() {
    assertTrue(guest.getCheckedOutBooks().isEmpty());

    guest.checkOutBook(book1);
    assertEquals(1, guest.getCheckedOutBooks().size());
    assertEquals(book1, guest.getCheckedOutBooks().get(0));

    guest.returnBook(book1);
    assertTrue(guest.getCheckedOutBooks().isEmpty());
  }
}
