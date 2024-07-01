package com.codedifferently.lesson9.mohamedibrahim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class PatronTest {
  @Test
  void testPatron_create() {
    // Arrange
    var name = "Joe";
    var id = 40;

    // Act
    Patron patron = new Patron(name, id);

    // Assert
    assertEquals("Joe", patron.getName());
    assertEquals(40, patron.getId());
  }

  @Test
  void testCheckOut() {
    // Arrange
    var name = "Joe";
    var id = 40;
    Library library = new Library();
    Book book1 = new Book("Book", 1, "John Book", 3000, library);
    Book book2 = new Book("Book 2, The Return of Book", 2, "John Book", 3000, library);
    Book book3 = new Book("Book 3, Books Revenge", 3, "John Book", 3000, library);
    Book book4 = new Book("Book 4, The Final Book", 4, "John Book", 3000, library);
    ArrayList<Book> books = new ArrayList<>();

    // Act
    Patron patron = new Patron(name, id);
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    patron.checkOutBooks(library, books);

    // Assert
    assertEquals(books, patron.getCheckedOutBooks());
  }

  @Test
  void testCheckIn() {
    // Arrange
    var name = "Joe";
    var id = 40;
    Library library = new Library();
    Book book1 = new Book("Book", 1, "John Book", 3000, library);
    Book book2 = new Book("Book 2, The Return of Book", 2, "John Book", 3000, library);
    Book book3 = new Book("Book 3, Books Revenge", 3, "John Book", 3000, library);
    Book book4 = new Book("Book 4, The Final Book", 4, "John Book", 3000, library);
    ArrayList<Book> books = new ArrayList<>();

    // Act
    Patron patron = new Patron(name, id);
    books.add(book1);
    books.add(book2);
    books.add(book3);
    books.add(book4);
    patron.checkOutBooks(library, books);

    // Assert
    assertEquals(books, patron.getCheckedOutBooks());
    patron.checkInBook(library, book1);
    patron.checkInBook(library, book2);
    books.remove(book1);
    books.remove(book2);
    assertEquals(patron.getCheckedOutBooks(), books);
  }
}
