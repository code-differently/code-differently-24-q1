package com.codedifferently.lesson9.LibraryManagementSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.LibraryManagementSystem.Book;
import com.codedifferently.lesson9.LibraryManagementSystem.Library;
import com.codedifferently.lesson9.LibraryManagementSystem.Patron;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the {@link com.codedifferently.lesson9.LibraryManagementSystem.Library} class.
 */
public class LibraryTest {
    private Library library;
    private Book book;

    /**
     * Set up the library and book for each test.
     */
    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("The Pragmatic Programmer", "9780135957059", "David Thomas, Andrew Hunt", 320);
    }

    /**
     * Test adding a book to the library.
     */
    @Test
    public void testAddBook() {
        library.addBook(book);
        List<Book> books = library.getBooks();
        assertEquals(1, books.size());
        assertEquals(book, books.get(0));
    }

    /**
     * Test removing a book from the library.
     */
    @Test
    public void testRemoveBook() {
        library.addBook(book);
        library.removeBook(book);
        List<Book> books = library.getBooks();
        assertEquals(0, books.size());
    }

    /**
     * Test checking out a book from the library.
     */
    @Test
    public void testCheckOutBook() {
        Patron patron = new Patron("John Doe");
        library.registerPatron(patron);

        library.checkOutBook(book, patron);
        assertTrue(book.isCheckedOut());
        assertTrue(patron.getCheckedOutBooks().contains(book));
    }

    /**
     * Test returning a book to the library.
     */
    @Test
    public void testReturnBook() {
        Patron patron = new Patron("John Doe");
        library.registerPatron(patron);
        library.checkOutBook(book, patron);

        library.returnBook(book, patron);
        assertFalse(book.isCheckedOut());
        assertFalse(patron.getCheckedOutBooks().contains(book));
    }
}
