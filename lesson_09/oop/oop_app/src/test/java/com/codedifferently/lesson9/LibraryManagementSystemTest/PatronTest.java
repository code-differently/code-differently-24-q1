package com.codedifferently.lesson9.LibraryManagementSystemTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.LibraryManagementSystem.Patron;
import com.codedifferently.lesson9.LibraryManagementSystem.Book;
import org.junit.jupiter.api.Test;

/**
 * Test class for Patron class.
 */
public class PatronTest {

    /**
     * Test the constructor of the Patron class.
     */
    @Test
    public void testPatronConstructor() {
        // Arrange
        String name = "John Doe";

        // Act
        Patron patron = new Patron(name);

        // Assert
        assertEquals(name, patron.getName());
    }

    /**
     * Test setting the name of the patron.
     */
    @Test
    public void testSetName() {
        // Arrange
        Patron patron = new Patron("John Doe");
        String newName = "Jane Smith";

        // Act
        patron.setName(newName);

        // Assert
        assertEquals(newName, patron.getName());
    }

    /**
     * Test adding a checked out book to the patron's list of checked out books.
     */
    @Test
    public void testAddCheckedOutBook() {
        // Arrange
        Patron patron = new Patron("John Doe");
        Book book = new Book("The Pragmatic Programmer", "9780135957059", "David Thomas, Andrew Hunt", 320);

        // Act
        patron.addCheckedOutBook(book);

        // Assert
        assertTrue(patron.getCheckedOutBooks().contains(book));
    }

    /**
     * Test removing a checked out book from the patron's list of checked out books.
     */
    @Test
    public void testRemoveCheckedOutBook() {
        // Arrange
        Patron patron = new Patron("John Doe");
        Book book = new Book("The Pragmatic Programmer", "9780135957059", "David Thomas, Andrew Hunt", 320);
        patron.addCheckedOutBook(book);

        // Act
        patron.removeCheckedOutBook(book);

        // Assert
        assertFalse(patron.getCheckedOutBooks().contains(book));
    }
}
