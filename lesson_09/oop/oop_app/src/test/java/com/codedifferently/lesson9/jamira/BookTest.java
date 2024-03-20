package com.codedifferently.lesson9.jamira;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookTest {
    private Book book;

    

    @Test
public void testGetters() {
    List<String> authors = new ArrayList<> ();
    authors.add("Author1");
    authors.add("Author2");
    Book book = new Book("Title", "ISBN123", authors, 200, false);
    
    List<String> expectedAuthors = new ArrayList<> ();
    expectedAuthors.add("Author1");
    expectedAuthors.add("Author2");

    assertEquals("Title", book.getTitle());
    assertEquals("ISBN123", book.getIsbn());
    assertEquals(expectedAuthors, book.getAuthors());
    assertEquals(200, book.getNumPages());
    assertFalse(book.isCheckedOut());
}


    @Test
    public void testSetters() {
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());

        book.setIsbn("NEWISBN123");
        assertEquals("NEWISBN123", book.getIsbn());

        List<String> newAuthors = List.of("New Author");
        book.setAuthors(newAuthors);
        assertEquals(newAuthors, book.getAuthors());

        book.setNumPages(300);
        assertEquals(300, book.getNumPages());

        book.setCheckedOut(true);
        assertTrue(book.isCheckedOut());
    }
}


