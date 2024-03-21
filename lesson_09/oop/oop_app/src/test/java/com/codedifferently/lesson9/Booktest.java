package com.codedifferently.lesson9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson9.KyvonThompsonlesson09.Book;
import org.junit.jupiter.api.Test;

public class Booktest {

  /** Test class for the {@link com.codedifferently.lesson9.LibraryManagementSystem.Book} class. */
  class BookTest {

    /** Test the constructor of the Book class. */
    @Test
    public void testBookConstructor() {
      // Arrange
      Boolean checkedOut = false;
      String authors = "Frank Miller";
      String title = "The Dark Knight Returns";
      int pageNumber = 250;
      float isbn = (float) 18.9595;

      // Act
      Book book = new Book(checkedOut, authors, title, pageNumber, isbn);

      // Assert
      assertEquals(title, book.getTitle());
      assertEquals(isbn, book.getIsbn());
      assertEquals(authors, book.getAuthors());
      assertEquals(pageNumber, book.getPageNumber());
    }
  }
}
