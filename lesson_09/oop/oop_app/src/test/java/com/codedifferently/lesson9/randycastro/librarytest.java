package com.codedifferently.lesson9.randycastro;

import com.codedifferently.lesson9.randycastro.library.Book;
import org.junit.jupiter.api.Test;

public class librarytest {

  public class BookTest {

    @Test
    // testing Book constructor
    // Arrange
    public void testBookConstructor() {
      String title = "dd";
      String isbn = "f32d";
      String author = "mas";
      int page = 33;
      boolean checkedOut = false;
      // Act
      Book book = new Book("efea", "f32d", "mas", 33, false);
      // Assert
      assesrtsEquals(title, book.getTitle());
      assertsEquals(isbn, book.getIsbn());
      assertsEquals(author, book.getAuthor());
      assertsEquals (page, book.getPage());
      assesrtsEquals(checkedOut, book.getCheckedout());
    }
  }
}
