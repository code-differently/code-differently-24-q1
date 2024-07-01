package com.codedifferently.lesson9.sherllin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

// We want to define a book and keep track of its title, isbn, author(s), number of pages, and
// whether it is checked out or not.
// We want define a patron with properties including their name and the books they have checked out.
// We want to define a library that:
// Allows us to add/remove a book to and from its collection of books.
// Allows us to register new patrons
// Allows us to check out books to patrons.
// Allows us to return books from patrons.

public class BookTest {

  @Test
  public void testBookProperties() {
    // Arrange
    String title = "The Alchemist";
    long isbn = 9780061122415L;
    String author = "Paulo Coelho";
    int pages = 208;
    boolean checkedOut = false;

    // Act
    Book theAlchemist = new Book(title, isbn, author, pages, checkedOut);

    // Assert
    assertEquals(title, theAlchemist.getBookTitle());
    assertEquals(isbn, theAlchemist.getIsbn());
    assertEquals(author, theAlchemist.getAuthor());
    assertEquals(pages, theAlchemist.getPages());
    assertEquals(checkedOut, theAlchemist.checkedOut());

    // Test additional books
    Book theCatInTheHat = new Book(title, isbn, author, pages, checkedOut);
    assertEquals(title, theCatInTheHat.getBookTitle());
    assertEquals(isbn, theCatInTheHat.getIsbn());
    assertEquals(author, theCatInTheHat.getAuthor());
    assertEquals(pages, theCatInTheHat.getPages());
    assertEquals(checkedOut, theCatInTheHat.checkedOut());

    Book atomicHabits = new Book(title, isbn, author, pages, checkedOut);
    assertEquals(title, atomicHabits.getBookTitle());
    assertEquals(isbn, atomicHabits.getIsbn());
    assertEquals(author, atomicHabits.getAuthor());
    assertEquals(pages, atomicHabits.getPages());
    assertEquals(checkedOut, atomicHabits.checkedOut());
  }

  @Test
  public void testPatronProperties() {
    Patron patron = new Patron("Nathalie", 3);
    String name = "Nathalie";
    int bookCheckedOut = 3;
    assertEquals(name, patron.getName());
    assertEquals(bookCheckedOut, patron.getBookCheckedOut());
  }

  @Test
  public void testAddBook() {
    Library library = new Library();
    library.addBook(9780316769488L);
    library.addBook(9780142437209L);
    library.addBook(9780743273565L);

    assertEquals(3, library.getBookStatus().size());
    assertEquals(Boolean.FALSE, library.getBookStatus().get(9780316769488L));
    assertEquals(Boolean.FALSE, library.getBookStatus().get(9780142437209L));
    assertEquals(Boolean.FALSE, library.getBookStatus().get(9780743273565L));
  }

  @Test
  public void testRemoveBook() {
    Library library = new Library();
    library.addBook(9780316769488L);
    library.addBook(9780142437209L);
    library.removeBook(9780316769488L);

    Map<Long, Boolean> expectedBookStatus = new HashMap<>();
    expectedBookStatus.put(9780142437209L, false);

    assertEquals(expectedBookStatus, library.getBookStatus());
  }

  @Test
  public void testRegisterPatron() {
    Library library = new Library();
    library.registerPatron("Lily");
    library.registerPatron("Dali");

    assertEquals(2, library.getPatronBooks().size());
    assertEquals(Integer.valueOf(0), library.getPatronBooks().get("Lily"));
    assertEquals(Integer.valueOf(0), library.getPatronBooks().get("Dali"));
  }

  @Test
  public void testCheckoutAndReturnBook() {
    Library library = new Library();
    library.addBook(9780316769488L);
    library.registerPatron("Lily");
    library.registerPatron("Dali");

    library.checkoutOrReturnBook(9780316769488L, "Lily", true);
    library.checkoutOrReturnBook(9780316769488L, "Dali", true);
    library.checkoutOrReturnBook(9780316769488L, "Dali", true);

    assertEquals(Boolean.TRUE, library.getBookStatus().get(9780316769488L));
    assertEquals(Integer.valueOf(1), library.getPatronBooks().get("Lily"));
    assertEquals(Integer.valueOf(0), library.getPatronBooks().get("Dali"));

    library.checkoutOrReturnBook(9780316769488L, "Dali", false);
    library.checkoutOrReturnBook(9780316769488L, "Lily", false);

    assertEquals(Boolean.FALSE, library.getBookStatus().get(9780316769488L));
    assertEquals(Integer.valueOf(0), library.getPatronBooks().get("Lily"));
    assertEquals(Integer.valueOf(0), library.getPatronBooks().get("Dali"));
  }
}
