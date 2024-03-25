package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;

import java.beans.Transient;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.bytebuddy.agent.builder.AgentBuilder;

class LibraryTest {
  private Library classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Library("compton-library");
  }

  @Test
  void testLibrary_canAddBooks() {
    // Arrange
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    // Act
    classUnderTest.addBook(book1);
    classUnderTest.addBook(book2);
    // Assert
    assertThat(classUnderTest.hasBook(book1)).isTrue();
    assertThat(classUnderTest.hasBook(book2)).isTrue();
  }

@Test
Dvd = dvd new Dvd ""
Librarian librarian = new Librarian("Randy Castro", "Randy@example.com");
classUnderTest.addDvd (dvd, librarian);
//Assert
assertThat (classUnderTest.hasDvd(dvd)).isTrue();


  @Test
  void testLibrary_canRemoveBooks() {
    // Arrange
    Book book1 =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Book book2 = new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    classUnderTest.addBook(book1);
    classUnderTest.addBook(book2);
    // Act
    classUnderTest.removeBook(book1);
    classUnderTest.removeBook(book2);
    // Assert
    assertThat(classUnderTest.hasBook(book1)).isFalse();
    assertThat(classUnderTest.hasBook(book2)).isFalse();
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
    classUnderTest.addBook(book);
    classUnderTest.addPatron(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutBook(book, patron);
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
    classUnderTest.addBook(book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutBook(book, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInBook(book, patron);
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
    classUnderTest.addBook(book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutBook(book, patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutBook(book, patron);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
  }

  @Test
  void testLibrary_preventsRemovingPatronWithCheckedOutBooks() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addBook(book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutBook(book, patron);
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
    classUnderTest.addBook(book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutBook(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeBook(book))
        .isInstanceOf(BookCheckedOutException.class)
        .hasMessage("Cannot remove checked out book.");
  }

  @Test
  void testLibrary_allowLibrarianToCheckout() {
  // Arange
  Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Librarian librarian = new Librarian("Jane Doe", "jane@example.com");
    classUnderTest.addBook(book);
    classUnderTest.addLibrarian(librarian);
    
//Act
boolean wasCheckedOut = classUnderTest.checkOutBook(book, librarian);
boolean wasReturned = classUnderTest.checkInBook(book, librarian);
//Assert
assertThat(wasCheckedOut).isTrue();
assertThat( wasReturned) .isTrue();
assertThat ( classUnderTest.isCheckedOut(book)) .isFalse();
assertThat( librarian.getCheckedOutBooks().contains(book))isFalse();
  }
}
