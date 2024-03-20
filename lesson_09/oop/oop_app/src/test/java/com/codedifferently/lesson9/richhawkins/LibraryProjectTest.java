package test.java.com.codedifferently.lesson9.richhawkins;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import main.java.com.codedifferently.lesson9.richhawkins.AlreadyCheckedOutException;
import main.java.com.codedifferently.lesson9.richhawkins.Book;
import main.java.com.codedifferently.lesson9.richhawkins.Library;
import main.java.com.codedifferently.lesson9.richhawkins.Patron;
import org.junit.jupiter.api.Test;

public class LibraryProjectTest {
  @Test
  public void testBookAccessors() {
    List<String> authors = new ArrayList<>();
    authors.add("John Doe");
    authors.add("Jane Doe");

    Book book = new Book("A Story About Something", 7654321, authors, 350, false);
    List<String> newAuthors = new ArrayList<>();
    newAuthors.add("Abe Lincoln");

    book.setCheckedOut(true);
    assertEquals(true, book.getCheckedOut());
    book.setTitle("Fun");
    assertEquals("Fun", book.getTitle());
    book.setIsbn(1234567);
    assertEquals(1234567, book.getIsbn());
    book.setAuthors(newAuthors);
    assertEquals(newAuthors, book.getAuthors());
    book.setNumberOfPages(250);
    assertEquals(250, book.getNumberOfPages());
  }

  @Test
  public void testPatronAccessors() {
    Patron patron = new Patron("Rich");
    HashSet<String> books = new HashSet<>();
    books.add("A New Tale");
    books.add("A Newer Tale");

    patron.setName("Nick");
    assertEquals("Nick", patron.getName());
    patron.setCheckedOutBooks(books);
    assertEquals(books, patron.getCheckedOutBooks());
  }

  @Test
  public void testAddBook() {
    Library library = new Library();
    List<String> authors = new ArrayList<>();
    authors.add("John Doe");
    Book book = new Book("Test Book", 1234, authors, 145, false);

    library.addBook(book);

    assertTrue(library.getBookCollection().contains(book));
  }

  @Test
  public void testRemoveBook() {
    Library library = new Library();
    List<String> authors = new ArrayList<>();
    authors.add("John Doe");
    Book book = new Book("Test Book", 1234, authors, 145, false);

    library.removeBook(book);

    assertTrue(!library.getBookCollection().contains(book));
  }

  @Test
  public void testRegisterNewPatron() {
    Library library = new Library();
    Patron patron = new Patron("Rich");

    library.registerNewPatron(patron);

    assertTrue(library.getPatrons().contains(patron));
  }

  @Test
  public void testCheckOutBook() {
    Library library = new Library();
    Book book = new Book("Test Book", 1234, new ArrayList<>(), 145, false);
    Patron patron1 = new Patron("John Doe");
    Patron patron2 = new Patron("Jane Doe");

    // Add the book to the library
    library.addBook(book);

    // Check out the book
    library.checkOutBook(book, patron1);

    // Check if the book is marked as checked out
    assertTrue(book.getCheckedOut());

    // Check to see if patron1's checkedoutbooks contains new book
    assertTrue(patron1.getCheckedOutBooks().contains(book.getTitle()));

    // Try to check out the book to patron2 (should fail)
    try {
      library.checkOutBook(book, patron2);
      fail("Expected AlreadyCheckedOutException was not thrown");
    } catch (AlreadyCheckedOutException e) {
      // Expected exception, do nothing
    }
    assertTrue(book.getCheckedOut());
    assertTrue(patron1.getCheckedOutBooks().contains(book.getTitle()));
  }
}
