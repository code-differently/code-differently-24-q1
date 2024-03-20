package com.codedifferently.lesson9.javyenwarelesson09;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BookTest {

    @Test
    public void testGettersAndSetters() {
        // Creating the Book object
        Book book = new Book("Sample Title", "1234567890", "Sample name", (short) 200, false);

        // Test getters
        assertEquals("Sample Title", book.getTitle());
        assertEquals("1234567890", book.getIsbn());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(200, book.getNumberOfPages());
        assertFalse(book.CheckedOut());

        // Testing the setters
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());

        book.setIsbn("0987654321");
        assertEquals("0987654321", book.getIsbn());

        book.setAuthor("Jane Smith");
        assertEquals("Jane Smith", book.getAuthor());

        book.setNumberOfPages((short) 300);
        assertEquals(300, book.getNumberOfPages());

        book.setCheckedOut(true);
        assertTrue(book.CheckedOut());
    }
}
