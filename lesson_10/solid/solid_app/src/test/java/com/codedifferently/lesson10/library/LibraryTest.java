package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.List;
import org.junit.jupiter.api.Test;

class LibraryTest {
  private Library classUnderTest = new Library("12342");
  private Librarian librarian = new Librarian("John Book", "0");

  @Test
  void testLibrary_canAddBooks() {
    // Arrange
    LibraryAsset newspaper = new Newspaper("New Hit! The Great Gatsby", "978-73565");
    LibraryAsset magazine = new Magazine("Behind the creator of Magazine the Movie", "978-00084");
    // Act
    classUnderTest.addAsset(librarian, newspaper);
    classUnderTest.addAsset(librarian, magazine);
    // Assert
    assertThat(classUnderTest.hasAsset(newspaper)).isTrue();
    assertThat(classUnderTest.hasAsset(magazine)).isTrue();
  }

  @Test
  void testLibrary_canRemoveBooks() {
    // Arrange
    LibraryAsset dvd1 = new Dvd("The Great Gatsby", "978-0743273565");
    LibraryAsset dvd2 = new Dvd("To Kill a Mockingbird", "978-0061120084");
    classUnderTest.addAsset(librarian, dvd1);
    classUnderTest.addAsset(librarian, dvd2);
    // Act
    classUnderTest.removeAsset(librarian, dvd1);
    classUnderTest.removeAsset(librarian, dvd2);
    // Assert
    assertThat(classUnderTest.hasAsset(dvd1)).isFalse();
    assertThat(classUnderTest.hasAsset(dvd2)).isFalse();
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
    LibraryAsset book =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutItem(book, patron);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(patron.getCheckedOutBooks(classUnderTest).contains(book)).isTrue();
  }

  @Test
  void testLibrary_allowPatronToCheckInBook() {
    // Arrange
    LibraryAsset dvd = new Dvd("DVD", "978-0743273");
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, dvd);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(dvd, patron);
    // Act
    boolean wasReturned = classUnderTest.checkInItem(dvd, patron);
    // Assert
    assertThat(wasReturned).isTrue();
    assertThat(classUnderTest.isCheckedOut(dvd)).isFalse();
    assertThat(patron.getCheckedOutBooks(classUnderTest).contains(dvd)).isFalse();
  }

  @Test
  void testLibrary_preventsMultipleCheckouts() {
    // Arrange
    LibraryAsset dvd = new Dvd("DVD 2, Dvd is not done", "978-0743565");
    Patron patron = new Patron("John Doe", "john@example.com");
    classUnderTest.addAsset(librarian, dvd);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(dvd, patron);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutItem(dvd, patron);
    // Assert
    assertThat(wasCheckedOut).isFalse();
    assertThat(classUnderTest.isCheckedOut(dvd)).isTrue();
  }

  @Test
  void testLibrary_preventsRemovingPatronWithCheckedOutBooks() {
    // Arrange
    LibraryAsset book =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
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
    LibraryAsset book =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Patron patron = new Patron("Jane Doe", "jane@example.com");
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addPatron(patron);
    classUnderTest.checkOutItem(book, patron);
    // Act
    assertThatThrownBy(() -> classUnderTest.removeAsset(librarian, book))
        .isInstanceOf(BookCheckedOutException.class)
        .hasMessage("Cannot remove checked out book.");
  }

  @Test
  void testLibrary_Search() {
    // Arrange
    LibraryAsset book =
        new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    LibraryAsset book1 = new Book("Book", "978-0743273566", List.of("John Book"), 3000);
    classUnderTest.addAsset(librarian, book);
    classUnderTest.addAsset(librarian, book1);
    // Act
    assertThat(classUnderTest.assetSearch(book1).toString().equals(book1.toString()));
  }

  @Test
  void testAssets_ThatCantBeCheckOut() {
    // Arrange
    LibraryAsset magazine = new Magazine("title", "986-0743273565");
    LibraryAsset newspaper = new Newspaper("title of today", "986-0743273565");
    classUnderTest.addAsset(librarian, magazine);
    classUnderTest.addAsset(librarian, newspaper);
    // Act
    assertThat(classUnderTest.checkOutItem(newspaper, librarian)).isFalse();
    assertThat(classUnderTest.checkOutItem(newspaper, librarian)).isFalse();
  }
}
