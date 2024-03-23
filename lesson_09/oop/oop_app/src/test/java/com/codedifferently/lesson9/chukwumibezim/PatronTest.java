package com.codedifferently.lesson9.chukwumibezim;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.chukwumaibezim.Book;
import com.codedifferently.lesson9.chukwumaibezim.Library;
import com.codedifferently.lesson9.chukwumaibezim.Patron;
import org.junit.jupiter.api.Test;

public class PatronTest {

  @Test
  public void testCheckOutBook() {
    Book book1 = new Book("The Color Purple", "9780156031820", "Alice Walker", 304);
    Book book2 = new Book("Beloved", "9781400033416", "Toni Morrison", 324);
    Book book3 = new Book("I Know Why the Caged Bird Sings", "9780345514400", "Maya Angelou", 304);
    Book book4 =
        new Book(
            "Monster: The Autobiography of an L.A. Gang Member",
            "9780802141446",
            "Sanyika Shakur",
            400);

    Patron patron = new Patron("Steph Curry");
    Library library = new Library();

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);

    library.checkOutBook(book1, patron);
    library.checkOutBook(book2, patron);
    library.checkOutBook(book3, patron);
    library.checkOutBook(book4, patron);

    assertTrue(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));
    assertTrue(patron.getCheckedOutBooks().contains(book4));
  }

  @Test
  public void testReturnBook() {
    Book book1 = new Book("The Color Purple", "9780156031820", "Alice Walker", 304);
    Book book2 = new Book("Beloved", "9781400033416", "Toni Morrison", 324);
    Book book3 = new Book("I Know Why the Caged Bird Sings", "9780345514400", "Maya Angelou", 304);
    Book book4 =
        new Book(
            "Monster: The Autobiography of an L.A. Gang Member",
            "9780802141446",
            "Sanyika Shakur",
            400);

    Patron patron = new Patron("Steph Curry");
    Library library = new Library();

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);
    library.addBook(book4);

    library.checkOutBook(book1, patron);
    library.checkOutBook(book2, patron);
    library.checkOutBook(book3, patron);
    library.checkOutBook(book4, patron);

    assertTrue(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));
    assertTrue(patron.getCheckedOutBooks().contains(book4));

    library.returnBook(book1, patron);

    assertFalse(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));
    assertTrue(patron.getCheckedOutBooks().contains(book4));
  }
}
