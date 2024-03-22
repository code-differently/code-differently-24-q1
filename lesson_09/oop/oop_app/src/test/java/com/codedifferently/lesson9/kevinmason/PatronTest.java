package com.codedifferently.lesson9.kevinmason;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue; // Import statically assertTrue method

import java.util.List;
import org.junit.jupiter.api.Test;

public class PatronTest {

  @Test
  public void testAddCheckedOutBook() {
    // Create a patron
    Patron patron = new Patron("John Doe");

    // Create a book
    Book book = new Book("Test Book", "ISBN123", "Test Author", 200);

    // Add the book to the patron's checked out books
    patron.addCheckedOutBook(book);

    // Retrieve the list of checked out books
    List<Book> checkedOutBooks = patron.getCheckedOutBooks();

    // Verify that the book was added to the list of checked out books
    assertTrue(checkedOutBooks.contains(book));
  }
}
