package com.codedifferently.lesson9.LibraryManagementSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson9.LibraryManagementSystem.Book;
import org.junit.jupiter.api.Test;

/** Test class for the {@link com.codedifferently.lesson9.LibraryManagementSystem.Book} class. */
public class BookTest {

  /** Test the constructor of the Book class. */
  @Test
  public void testBookConstructor() {
    // Arrange
    String title = "The Pragmatic Programmer";
    String isbn = "9780135957059";
    String author = "David Thomas, Andrew Hunt";
    int numberOfPages = 320;

    // Act
    Book book = new Book(title, isbn, author, numberOfPages);

    // Assert
    assertEquals(title, book.getTitle());
    assertEquals(isbn, book.getIsbn());
    assertEquals(author, book.getAuthor());
    assertEquals(numberOfPages, book.getNumberOfPages());
  }
}
