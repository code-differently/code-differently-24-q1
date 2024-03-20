package com.codedifferently.lesson9.mohamedibrahim;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    Library library = new Library();

    // Act
    author.add("George R. R. Martin");
    Book iceAndFire = new Book(name, isbn, author, pageNums, library);

    // Assert
    assertEquals("Song of ice and fire", iceAndFire.getName());
    assertEquals(01234567, iceAndFire.getIsbn());
    assertEquals(author, iceAndFire.getAuthors());
    assertEquals(1184, iceAndFire.getPageNums());
    assertEquals(false, iceAndFire.getStatus());
  }

  @Test
  void testAuthorAdditionAndRemoval(){
    //Arrange
    ArrayList<String> authors =new ArrayList<>();
    Book book1 = new Book("Book", 1, "John Book", 3000, null);
    // Book book3 = new Book("Book 3, Books Revenge", 3, "John Book", 3000, null);
    // Book book4 = new Book("Book 4, The Final Book", 4, "John Book", 3000, null);

    //Act
    book1.addAuthor("John Book Jr.");
    authors.add("John Book");
    authors.add("John Book Jr.");


    //Assert
    assertEquals(authors ,book1.getAuthors());
    book1.removeAuthor("John Book Jr.");
    authors.remove("John Book Jr.");
    assertEquals(authors, book1.getAuthors());
  }

  @Test
  void testEqualsOveride(){
    Book book2 = new Book("Book 2, The Return of Book", 2, "John Book", 3000, null);
    Book book3 = new Book("Book 3, Books Revenge", 3, "John Book", 3000, null);

    assertThat(book2.equals(new Book("Book 2, The Return of Book", 2, "John Book", 3000, null)));
    assertThat(!(book2.equals(book3)));
  }

  @Test
  void test
}
