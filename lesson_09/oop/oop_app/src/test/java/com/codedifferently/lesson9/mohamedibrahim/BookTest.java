package com.codedifferently.lesson9.mohamedibrahim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class BookTest {

  @Test
  void testBook_create() {
    // Arrange
    var name = "Song of ice and fire";
    var isbn = 01234567;
    ArrayList<String> author = new ArrayList<String>();
    int pageNums = 1184;

    // Act
    author.add("George R. R. Martin");
    Book iceAndFire = new Book(name, isbn, author, pageNums);

    // Assert
    assertEquals("Song of ice and fire", iceAndFire.getName());
    assertEquals(01234567, iceAndFire.getIsbn());
    assertEquals(author, iceAndFire.getAuthor());
    assertEquals(1184, iceAndFire.getPageNums());
    assertEquals(false, iceAndFire.getStatus());
  }
}
