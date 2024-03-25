package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

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
  void testLibrary_canAddDvds() {
      // Arrange
      Dvd dvd1 = new Dvd("The Martian", 12345);
      Dvd dvd2 = new Dvd("Legally Blonde", 98765);
      // Act
      classUnderTest.addDvd(dvd1);
      classUnderTest.addDvd(dvd2);
      // Assert
      assertThat(classUnderTest.hasDvd(dvd1)).isTrue();
      assertThat(classUnderTest.hasDvd(dvd2)).isTrue();
  }
  

  @Test
  void testLibrary_canRemoveDvds() {
      // Arrange
      Dvd dvd1= new Dvd("The Martian", 12345);
      Dvd dvd2 = new Dvd("Legally Blonde", 98765);
  
      classUnderTest.addDvd(dvd1);
      classUnderTest.addDvd(dvd2);
      // Act
      classUnderTest.removeDvd(dvd1);
      classUnderTest.removeDvd(dvd2);
      // Assert
      assertThat(classUnderTest.hasDvd(dvd1)).isFalse();
      assertThat(classUnderTest.hasDvd(dvd2)).isFalse();
  }
  
  @Test
  void testLibrary_canAddMagazine() {
      // Arrange
      Magazine magazine1 = new Magazine("Vogue", 45678);
      Magazine magazine2 = new Magazine("Times", 899938);
      // Act
      classUnderTest.addMagazine(magazine1);
      classUnderTest.addMagazine(magazine2);
      // Assert
      assertThat(classUnderTest.hasMagazine(magazine1)).isTrue();
      assertThat(classUnderTest.hasMagazine(magazine2)).isTrue();
  }

  @Test
  void testLibrary_canAddNewspaper() {
      // Arrange
      Newspaper newspaper1 = new Newspaper("The New York Times", 45678);
      Newspaper newspaper2 = new Newspaper("New York Post", 899938);
      // Act
      classUnderTest.addNewspaper(newspaper1);
      classUnderTest.addNewspaper(newspaper2);
      // Assert
      assertThat(classUnderTest.hasNewspaper(newspaper1)).isTrue();
      assertThat(classUnderTest.hasNewspaper(newspaper2)).isTrue();
  }

 @Test
    void testRemoveNewspaper() throws WrongLibraryException {
        // Arrange
        Library library = new Library("Test Library");
        Newspaper newspaper1 = new Newspaper("New York Times",45678);
        Newspaper newspaper2 = new Newspaper("New York Post", 899938);
        library.addNewspaper(newspaper1);
        library.addNewspaper(newspaper2);

        // Act
        library.removeNewspaper(newspaper1);

        // Assert
        assertThat(library.hasNewspaper(newspaper1)).isFalse(); 
        assertThat(library.hasNewspaper(newspaper2)).isTrue(); 
        assertThat(newspaper1.getLibrary()).isNull(); 
    }

    @Test
    void testRemoveMagaziner() throws WrongLibraryException {
        // Arrange
        Library library = new Library("Test Library");
        Magazine magazine1 = new Magazine("Vogue", 45678);
        Magazine magazine2 = new Magazine("Times", 899938);
        library.addMagazine(magazine1);
        library.addMagazine(magazine2);

        // Act
        library.removeMagazine(magazine1);

        // Assert
        assertThat(library.hasMagazine(magazine1)).isFalse(); 
        assertThat(library.hasMagazine(magazine2)).isTrue(); 
        assertThat(magazine1.getLibrary()).isNull(); 
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
  void testLibrary_canAddLibrarians() {
    // Arrange
    Librarian librarian1 = new Librarian("John Doe", 12345);
    Librarian librarian2 = new Librarian("Jane Doe", 98765);
    // Act
    classUnderTest.addLibrarian(librarian1);
    classUnderTest.addLibrarian(librarian2);
    // Assert
    assertThat(classUnderTest.hasLibrarian(librarian1)).isTrue();
    assertThat(classUnderTest.hasLibrarian(librarian2)).isTrue();
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
  void testLibrary_canRemoveLibrarians() {
    // Arrange
    Librarian librarian1 = new Librarian("John Doe", 12345);
    Librarian librarian2 = new Librarian("Jane Doe", 98765);
    classUnderTest.addLibrarian(librarian1);
    classUnderTest.addLibrarian(librarian2);
    // Act
    classUnderTest.removeLibrarian(librarian1);
    classUnderTest.removeLibrarian(librarian2);
    // Assert
    assertThat(classUnderTest.hasLibrarian(librarian1)).isFalse();
    assertThat(classUnderTest.hasLibrarian(librarian2)).isFalse();
  }

  @Test
  void testLibrary_allowsPatronToCheckoutBook() {
      // Arrange
      Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
      Patron patron = new Patron("John Doe", "john@example.com");
      Librarian librarian = new Librarian("Alice", 123456); 
      classUnderTest.addBook(book);
      classUnderTest.addPatron(patron);
      classUnderTest.addLibrarian(librarian);
  
      // Act
      boolean wasCheckedOut = classUnderTest.checkOutBook(book, patron, librarian); 
  
      // Assert
      assertThat(wasCheckedOut).isTrue();
      assertThat(classUnderTest.isCheckedOut(book)).isTrue();
      assertThat(patron.getCheckedOutBooks().contains(book)).isTrue();
  }
  
  @Test
  void testLibrary_allowsLibrarianToCheckoutBook() {
    // Arrange
    Book book = new Book("The Great Gatsby", "978-0743273565", List.of("F. Scott Fitzgerald"), 180);
    Librarian librarian = new Librarian("John Doe", 12385);
    classUnderTest.addBook(book);
    classUnderTest.addLibrarian(librarian);
    // Act
    boolean wasCheckedOut = classUnderTest.checkOutBook(book, librarian);
    // Assert
    assertThat(wasCheckedOut).isTrue();
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(librarian.getCheckedOutBooks().contains(book)).isTrue();
  }
  @Test
  void testLibrary_allowsPatronToCheckoutDvd() {
      // Arrange
      Library library = new Library("Test Library");
      Dvd dvd = new Dvd("The Martian", 1234);
      Patron patron = new Patron("John Doe", "john@example.com"); 
      library.addDvd(dvd);
      library.addPatron(patron);

      // Act
      boolean wasCheckedOut = library.checkOutDvd(dvd, patron); 

      // Assert
      assertThat(wasCheckedOut).isTrue();
      assertThat(library.isCheckedOut(dvd)).isTrue(); // DVD should be checked out
      assertThat(patron.getCheckedOutDvds().contains(dvd)).isTrue(); // Patron should have the DVD checked out
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
}
