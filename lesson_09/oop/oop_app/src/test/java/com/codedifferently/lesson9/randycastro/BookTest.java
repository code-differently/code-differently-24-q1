package com.codedifferently.lesson9.randycastro;

import com.codedifferently.lesson9.randycastro.BookTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BookTest{

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
      Book book = new Book(title, isbn, author, page, checkedOut);
      // Assert
            assertEquals(title, book.getTitle());
            assertEquals(isbn, book.getIsbn());
            assertEquals(author, book.getAuthor());
            assertEquals(page, book.getPage());
            assertEquals(checkedOut, book.getCheckedout());
    }
  
@Test

public void testBook(){
String title = "The Software Engineer Guidebook";
String isbn = "12345e";
String author = "Gergely Orosz";
int page = 405;
boolean checkedOut = false;
}


}
