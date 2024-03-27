package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author vscode
 */
public class PatronTest {

  private Patron patron;

  @BeforeEach
  void setUp() {
    patron = new Patron("Mark Wang", "markw@egmail.com");
  }

  @Test
  void testGetName() {
    assertThat(patron.getName()).isEqualTo("Mark Wang");
  }

  @Test
  void testGetEmail() {
    assertThat(patron.getEmail()).isEqualTo("markw@egmail.com");
  }

  @Test
  void testCheckOut() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Catcher in the Rye",
            List.of("J.D. Salinger"),
            224,
            "9780316769488");

    // Act
    patron.checkOut(book);

    // Assert
    assertThat(patron.getCheckedOutItems()).contains(book);
  }

  @Test
  void testCheckOut_AlreadyCheckedOut() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "The Great Gatsby",
            List.of("F. Scott Fitzgerald"),
            180,
            "9780743273565");

    // Act
    patron.checkOut(book);

    // Assert
    assertThatThrownBy(() -> patron.checkOut(book)).isInstanceOf(BookCheckedOutException.class);
  }

  @Test
  void testCheckIn() {
    // Arrange
    Book book =
        new Book(
            UUID.randomUUID(),
            "To Kill a Mockingbird",
            List.of("Harper Lee"),
            281,
            "978-0061120084");
    patron.checkOut(book);

    // Act
    patron.checkIn(book);

    // Assert
    assertThat(patron.getCheckedOutItems()).doesNotContain(book);
  }

  @Test
  void testAddLibrary() {
    // Arrange
    Library library1 = new Library();
    Library library2 = new Library();

    // Act
    patron.addLibrary(library1);
    patron.addLibrary(library2);

    // Assert
    assertThat(patron.getLibraries()).contains(library1, library2);
  }

  @Test
  void testRemoveLibrary() {
    // Arrange
    Library library1 = new Library();
    Library library2 = new Library();
    patron.addLibrary(library1);
    patron.addLibrary(library2);

    // Act
    patron.removeLibrary(library1);

    // Assert
    assertThat(patron.getLibraries()).containsOnly(library2);
  }
}
