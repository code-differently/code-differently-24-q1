package com.codedifferently.lesson9.mohamedibrahim;

import static org.assertj.core.api.Assertions.assertThat;
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

    Library library = new Library(books);
    books.add(new Book("name", 1, "Jessie", 1, library));
    books.add(new Book("name", 2, "James", 1, library));
    books.add(new Book("name", 3, "Meowth", 1, library));
    books.add(new Book("name", 1, "wobbuffet", 1, library));
    library = new Library(books);

    // Assert
    for (Book b : books) {
      assertThat(library.getShelves().containsValue(b));
    }
  }

  @Test
  void testPatronIdChecker() {
    Library library = new Library();
    Patron patron = new Patron("John", 0);

    library.addBook(new Book("Name", 0, "name2", 0, library));
    library.registerPatron(patron);

    assertEquals("John", library.getCurrentPatronsById().get(0).getName());
    assertThrows(
        UserAlreadyRegisteredException.class,
        () -> {
          library.registerPatron(new Patron("John", 0));
        });
  }

  @Test
  void testBookOrginValidation() {
    Library library = new Library();
    Library libs = new Library();

    library.addBook(new Book("Name", 0, "name2", 0, library));
    Book books = new Book("books", 1, "Henry Booker", 3, libs);

    assertThrows(
        BookOfDifferentOrginException.class,
        () -> {
          library.checkInBook(books, library);
        });
  }

  @Test
  void testBookCheckoutValadation() {
    Library library = new Library();

    Book book = new Book("books", 1, "Henry Booker", 3, library);

    assertThrows(
        BookNotFoundException.class,
        () -> {
          library.checkOutBook(book);
        });
  }

  @Test
  void testMassCheckOut() {
    Library library = new Library();
    ArrayList<Book> checkOutBooks = new ArrayList<>();
    Book book1 = (new Book("name", 1, "Jessie", 1, library));
    Book book2 = (new Book("name", 2, "James", 1, library));

    library.addBook(book1);
    library.addBook(new Book("name", 3, "Meowth", 1, library));
    library.addBook(book2);
    library.addBook(new Book("name", 1, "wobbuffet", 1, library));
    checkOutBooks.add(book2);
    checkOutBooks.add(book1);

    assertEquals(checkOutBooks, library.checkOutBooks(checkOutBooks));
  }
}
