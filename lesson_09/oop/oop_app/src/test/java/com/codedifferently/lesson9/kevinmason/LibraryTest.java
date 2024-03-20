package com.codedifferently.lesson9.kevinmason;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryTest {

    @Test
    public void testAddBook() {
        // Create a library
        Library library = new Library();

        // Create a book
        Book book = new Book("Test Book", "ISBN123", "Test Author", 200);

        // Add the book to the library
        library.addBook(book);

        // Retrieve the list of books from the library
        List<Book> books = library.getBooks();

        // Verify that the book was added to the library
        assertTrue(books.contains(book));
    }

    // You can add more test methods for other functionalities here...
}



