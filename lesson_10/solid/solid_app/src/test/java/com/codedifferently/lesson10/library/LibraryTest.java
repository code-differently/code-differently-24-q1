package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.ItemCheckedOutException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private Library classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Library("compton-library");
  }

  @Test
  void testLibrary_canAddMedia() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "rich@mail.com", classUnderTest);
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    // Act
    classUnderTest.addMedia(book1, librarian);
    classUnderTest.addMedia(book2, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(book1)).isTrue();
    assertThat(classUnderTest.hasMediaItem(book2)).isTrue();
  }

  @Test
  void testLibrary_canRemoveMedia() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    classUnderTest.addMedia(book1, librarian);
    classUnderTest.addMedia(book2, librarian);
    // Act
    classUnderTest.removeMediaItem(book1, librarian);
    classUnderTest.removeMediaItem(book2, librarian);
    // Assert
    assertThat(classUnderTest.hasMediaItem(book1)).isFalse();
    assertThat(classUnderTest.hasMediaItem(book2)).isFalse();
  }

  @Test
  void testLibrary_canAddPatrons() {
    // Arrange
    Patron patron1 = new Patron("John Doe", "john@example.com", classUnderTest);
    Patron patron2 = new Patron("Jane Doe", "jane@example.com", classUnderTest);
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
    Patron patron1 = new Patron("John Doe", "john@example.com", classUnderTest);
    Patron patron2 = new Patron("Jane Doe", "jane@example.com", classUnderTest);
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
  void testLibrary_allowsPatronToCheckoutMedia() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com", classUnderTest);
    classUnderTest.addMedia(book, librarian);
    classUnderTest.addPatron(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(patron.getCheckedOutMedia().contains(book)).isTrue();
  }

  @Test
  void testLibrary_allowPatronToCheckInMedia() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com", classUnderTest);
    classUnderTest.addMedia(book, librarian);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInMediaItem(book, patron);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isFalse();
    assertThat(patron.getCheckedOutMedia().contains(book)).isFalse();
  }

  @Test
  void testLibrary_preventsMultipleCheckouts() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com", classUnderTest);
    classUnderTest.addMedia(book, librarian);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutMediaItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
  }

  @Test
  void testLibrary_preventsRemovingPatronWithCheckedOutBooks() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com", classUnderTest);
    classUnderTest.addMedia(book, librarian);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removePatron(patron))
        .isInstanceOf(ItemCheckedOutException.class)
        .hasMessage("Cannot remove patron with checked out media.");
  }

  @Test
  void testLibrary_preventsRemovingCheckedOutMedia() {
    // Arrange
    Librarian librarian = new Librarian("Rich", "Rich@mail.com", classUnderTest);
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("Jane Doe", "jane@example.com", classUnderTest);
    classUnderTest.addMedia(book, librarian);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutMediaItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeMediaItem(book, librarian))
        .isInstanceOf(ItemCheckedOutException.class)
        .hasMessage("Cannot remove checked out media.");
  }
}
