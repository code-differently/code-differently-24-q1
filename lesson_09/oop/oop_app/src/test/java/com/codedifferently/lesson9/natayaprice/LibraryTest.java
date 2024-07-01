package com.codedifferently.lesson9.natayaprice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LibraryTest {

  @Test
  public void testAddBook() {
    Library library = new Library();
    Book book =
        new Book(
            "The Sisters Grimm: The Fairy-Tale Detectives", 571, "Michael Buckley", 176, false);
    library.addBook(book);
    List<Book> booksInLibrary = library.getBooks();
    // Assert that one book should be added to the library
    assertEquals(1, booksInLibrary.size(), "One book should be added to the library");
    // Assert that the added book is the same as the book in the library
    assertEquals(
        book, booksInLibrary.get(0), "Added book should be the same as the book in the library");
  }
}
