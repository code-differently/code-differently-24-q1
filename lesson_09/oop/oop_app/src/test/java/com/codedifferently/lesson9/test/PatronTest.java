package com.codedifferently.lesson9.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson9.library.Book;
import com.codedifferently.lesson9.library.Patron;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class PatronTest {

  @Test
  public void testPatronConstructor() {
    Patron patron = new Patron("Peter Parker");
    assertEquals("Peter Parker", patron.getName());
    assertEquals(new ArrayList<Book>(), patron.getCheckedOutBooks());
  }

  @Test
  public void testCheckOutComic() {
    Patron patron = new Patron("Tony Stark");
    Book comic = new Book("Avengers", "9781302921686", List.of("Stan Lee"), 300);
    patron.checkOutBook(comic);
    assertEquals(1, patron.getCheckedOutBooks().size());
  }
}
