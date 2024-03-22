package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.List;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private Library classUnderTest = new Library("12342");
  private Librarian librarian = new Librarian("John Book", "0");

  // @BeforeEach
  // void setUp() {
  //   classUnderTest = new Library("compton-library");
  // }

  @Test
  void testLibrary_canAddBooks() {
    // Arrange
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    // Act
    classUnderTest.addAsset(librarian, book1);
    classUnderTest.addAsset(librarian, book2);
    // Assert
    assertThat(classUnderTest.hasAsset(book1)).isTrue();
    assertThat(classUnderTest.hasAsset(book2)).isTrue();
  }

  @Test
  void testLibrary_canRemoveBooks() {
    // Arrange
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    classUnderTest.addAsset(librarian, book1);
    classUnderTest.addAsset(librarian, book2);
    // Act
    classUnderTest.removeAsset(librarian, book1);
    classUnderTest.removeAsset(librarian, book2);
    // Assert
    assertThat(classUnderTest.hasAsset(book1)).isFalse();
    assertThat(classUnderTest.hasAsset(book2)).isFalse();
  }

  @Test
  void testLibrary_canAddPatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com");
    Patron patron2 = new Patron("Jane Doe", "jane@example.com");
    // Act
    classUnderTest.addPatron(patron1);
    classUnderTest.addPatron(patron2);
    // Assert
    assertThat(classUnderTest.hasPatron(patron1)).isTrue();
    assertThat(classUnderTest.hasPatron(patron2)).isTrue();
  }

  @Test
  void testLibrary_canRemovePatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com");
    Patron patron2 = new Patron("Jane Doe", "jane@example.com");
    classUnderTest.addPatron(patron1);
    classUnderTest.addPatron(patron2);
    // Act
    classUnderTest.removePatron(patron1);
    classUnderTest.removePatron(patron2);
    // Assert
    assertThat(classUnderTest.hasPatron(patron1)).isFalse();
    assertThat(classUnderTest.hasPatron(patron2)).isFalse();
  }

  @Test
  void testLibrary_allowsPatronToCheckoutBook() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(patron.getCheckedOutBooks().contains(book)).isTrue();
  }

  @Test
  void testLibrary_allowPatronToCheckInBook() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(book, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInItem(book, patron);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isFalse();
    assertThat(patron.getCheckedOutBooks().contains(book)).isFalse();
  }

  @Test
  void testLibrary_preventsMultipleCheckouts() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(book, patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
  }

  @Test
  void testLibrary_preventsRemovingPatronWithCheckedOutBooks() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removePatron(patron))
        .isInstanceOf(BookCheckedOutException.class)
        .hasMessage("Cannot remove patron with checked out books.");
  }

  @Test
  void testLibrary_preventsRemovingCheckedOutBooks() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("Jane Doe", "jane@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeAsset(librarian, book))
        .isInstanceOf(BookCheckedOutException.class)
        .hasMessage("Cannot remove checked out book.");
  }
}
