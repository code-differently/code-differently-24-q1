package com.codedifferently.lesson9.jamira;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "ISBN1", List.of("Author1"), 100, true));
        books.add(new Book("Book2", "ISBN2", List.of("Author2"), 150, true));

        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book("New Book", "New ISBN", List.of("New Author"), 200, false);
        library.addBook(newBook);

        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("Book1", "ISBN1", List.of("Author1"), 100, true));
        expectedBooks.add(new Book("Book2", "ISBN2", List.of("Author2"), 150, true));
        expectedBooks.add(newBook);

        assertEquals(expectedBooks.size(), library.getBooks().size());
        assertEquals(expectedBooks, library.getBooks());
    }

    @Test
    public void testRemoveBook() {
        Book bookToRemove = new Book("Book1", "ISBN1", List.of("Author1"), 100, true);
        library.removeBook(bookToRemove);

        List<Book> expectedBooks = new ArrayList<>();
        expectedBooks.add(new Book("Book2", "ISBN2", List.of("Author2"), 150, true));

        assertEquals(expectedBooks.size(), library.getBooks().size());
        assertEquals(expectedBooks, library.getBooks());
    }
}
