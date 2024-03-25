package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronTest {

  private Patron classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Patron("John Doe", "johndoe@example.com");
    library = new Library("Library 1");
    library.addPatron(classUnderTest);
  }

  @Test
  void testPatron_created() {
    // Assert
    assertThat(classUnderTest.getName()).isEqualTo("John Doe");
    assertThat(classUnderTest.getId()).isEqualTo("johndoe@example.com");
  }

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = new Library("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Patron johndoe@example.com is not in library Library 2");
  }

  @Test
  void testGetCheckedOutBooks_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.getCheckedOutBooks())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for patron johndoe@example.com");
  }

  @Test
  void testGetCheckedOutBooks() {
    // Arrange
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    Set<Book> expectedBooks = new HashSet<>();
    expectedBooks.add(book1);
    expectedBooks.add(book2);
    Librarian librarian;

    library.addBook(book1, librarian);
    library.addBook(book2, librarian);
    library.checkOutBook(book1, classUnderTest);
    library.checkOutBook(book2, classUnderTest);

    // Act & Assert
    assertThat(classUnderTest.getCheckedOutBooks()).isEqualTo(expectedBooks);
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Patron{id='johndoe@example.com', name='John Doe'}");
  }

  @Test
  void testPatron_canCheckOutBook() {
    // Arrange
    Library library = new Library("Test Library");
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Librarian Name", "librarian@example.com");
    Book book =
        new Book("Test Book", "978-1234567890", Collections.singletonList("Test Author"), 200);

    library.addBook(book, librarian); // Adding book with librarian

    // Act
    boolean wasCheckedOut = patron.checkOutBook(book, library);

    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(patron.getCheckedOutBooks()).contains(book);
    assertThat(library.isCheckedOut(book)).isTrue();
  }

  @Test
  void testPatron_canReturnBook() {
    // Arrange
    Library library = new Library("Test Library");
    Patron patron = new Patron("John Doe", "john@example.com");
    Librarian librarian = new Librarian("Librarian Name", "librarian@example.com");
    Book book =
        new Book("Test Book", "978-1234567890", Collections.singletonList("Test Author"), 200);

    library.addBook(book, librarian); // Adding book with librarian
    patron.checkOutBook(book, library);

    // Act
    boolean wasReturned = patron.returnBook(book, library);

    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(patron.getCheckedOutBooks()).doesNotContain(book);
    assertThat(library.isCheckedOut(book)).isFalse();
  }
}
