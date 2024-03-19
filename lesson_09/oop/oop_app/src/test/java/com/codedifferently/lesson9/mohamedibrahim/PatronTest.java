package com.codedifferently.lesson9.mohamedibrahim;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class PatronTest {
  @Test
  void testPatron_create() {
    // Arrange
    var name = "Joe";
    Patron patron = new Patron(name, 40);
    ArrayList<Book> checkedOut = new ArrayList<Book>();
    Library library = new Library();

    // Act
    library.addBooks(new Book("Book 1", 1, "John Book Sr", 3000));
    library.addBooks(new Book("Book 2, Books Return", 2, "John Book Sr", 3000));
    library.addBooks(new Book("Book 3, Books Rising", 3, "John Book Jr", 3000));
    library.addBooks(new Book("Book 4, The Final Book", 4, "John Book Jr", 3000));
    library.registerPatron(patron);
    ArrayList<Book> bookShelf = library.getBooks();
    patron.checkOutBook(library, library.getBooks().get(2));
    checkedOut.add(library.getBooks().get(2));

    // Assert
    assertEquals("Joe", patron.getName());
    assertThat(patron.getCheckedOutBooks().contains(library.getBooks().get(2)));
    assertEquals(bookShelf, library.getBooks());
    assertThat(library.getCurrentPatronIds().contains(patron.getId()));
    assertThat(library.getCurrentPatrons().contains(patron));
  }
}
