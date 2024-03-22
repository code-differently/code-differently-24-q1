package com.codedifferently.lesson9.jamira;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
  private Library library;

  @BeforeEach
  public void setUp() {
    List<Book> books = new ArrayList<>();
    books.add(new Book("Book1", "ISBN1", List.of("Author1"), 100, true));
    books.add(new Book("Book2", "ISBN2", List.of("Author2"), 150, true));

    library = new Library();
    library.setBooks(books);
  }

  @Test
  public void testAddBook() {
    Book newBook = new Book("New Book", "New ISBN", List.of("New Author"), 200, false);
    Book book1 = library.getBooks().get(0);
    Book book2 = library.getBooks().get(1);

    library.addBook(newBook);

    List<Book> expectedBooks = new ArrayList<>();
    expectedBooks.add(book1);
    expectedBooks.add(book2);
    expectedBooks.add(newBook);

    assertEquals(expectedBooks.size(), library.getBooks().size());
    assertEquals(expectedBooks, library.getBooks());
  }

  @Test
  public void testRemoveBook() {
    Book book1 = library.getBooks().get(0);
    Book book2 = library.getBooks().get(1);
    library.removeBook(book1);

    List<Book> expectedBooks = new ArrayList<>();
    expectedBooks.add(book2);

    assertEquals(expectedBooks.size(), library.getBooks().size());
    assertEquals(expectedBooks, library.getBooks());
  }
}
