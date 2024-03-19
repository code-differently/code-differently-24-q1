package com.codedifferently.lesson9.mohamedibrahim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class LibraryTest {
  @Test
  void testLibrary_create() {
    // Arrange
    ArrayList<Book> books = new ArrayList<>();

    // Act
    books.add(new Book("name", 1, "Jessie", 1));
    books.add(new Book("name", 2, "James", 1));
    books.add(new Book("name", 3, "Meowth", 1));
    books.add(new Book("name", 1, "wobbuffet", 1));
    Library library = new Library(books);
    library.registerPatron(new Patron("John", 0));

    // Assert
    assertEquals(books, library.getBooks());
    assertThrows(
        UserAlreadyRegistered.class,
        () -> {
          library.registerPatron(new Patron("Jake", 0));
        });
    assertThrows(
        BookNotFound.class,
        () -> {
          library.checkOutBook(new Book("books", 1, "Henry Booker", 3));
        });
  }
}
