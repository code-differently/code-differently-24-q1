package com.codedifferently.lesson10.library;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public class LibrarianTest  {

  private Librarian classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Librarian("John Doe", 773629);
    library = new Library("Library 1");
    library.addLibrarian(classUnderTest);
  }
@Test
  void testLibrarian_created() {
    // Assert
    assertThat(classUnderTest.getName()).isEqualTo("John Doe");
    assertThat(classUnderTest.getEmpId()).isEqualTo("773629"); 
}

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = new Library("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Librarian, 2646282 is not in library Library 2");
  }

  @Test
  void testGetCheckedOutBooks_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.getCheckedOutBooks())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for Librarian 3392899");
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

    library.addBook(book1);
    library.addBook(book2);
    library.checkOutBook(book1, classUnderTest);
    library.checkOutBook(book2, classUnderTest);

    // Act & Assert
    assertThat(classUnderTest.getCheckedOutBooks()).isEqualTo(expectedBooks);
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Librarian{id='774849292', name='John Doe'}");
  }}

