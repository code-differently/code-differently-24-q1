package com.codedifferently.lesson9.chukwumibezim;

import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson9.chukwumaibezim.Book;
import com.codedifferently.lesson9.chukwumaibezim.Library;
import com.codedifferently.lesson9.chukwumaibezim.Patron;
import org.junit.jupiter.api.Test;

public class LibraryTest {

  @Test
  public void testCheckOutBook() {
    Book book1 = new Book("The Hate U Give", "9780062498533", "Angie Thomas", 464);
    Book book2 = new Book("Between the World and Me", "9780812993547", "Ta-Nehisi Coates", 176);
    Book book3 =
        new Book("Their Eyes Were Watching God", "9780061120060", "Zora Neale Hurston", 219);

    Patron patron = new Patron("Chukwuma Ibezim");
    Library library = new Library();

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    library.checkOutBook(book1, patron);
    library.checkOutBook(book2, patron);
    library.checkOutBook(book3, patron);

    assertTrue(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));
  }

  @Test
  public void testReturnBook() {
    Book book1 = new Book("The Hate U Give", "9780062498533", "Angie Thomas", 464);
    Book book2 = new Book("Between the World and Me", "9780812993547", "Ta-Nehisi Coates", 176);
    Book book3 =
        new Book("Their Eyes Were Watching God", "9780061120060", "Zora Neale Hurston", 219);

    Patron patron = new Patron("Chukwuma Ibezim");
    Library library = new Library();

    library.addBook(book1);
    library.addBook(book2);
    library.addBook(book3);

    library.checkOutBook(book1, patron);
    library.checkOutBook(book2, patron);
    library.checkOutBook(book3, patron);

    assertTrue(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));

    library.returnBook(book1, patron);

    assertFalse(patron.getCheckedOutBooks().contains(book1));
    assertTrue(patron.getCheckedOutBooks().contains(book2));
    assertTrue(patron.getCheckedOutBooks().contains(book3));
  }
}
