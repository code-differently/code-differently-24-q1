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
    assertThatThrownBy(() -> classUnderTest.getCheckedOutBooks(library))
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

    library.addAsset(new Librarian("Jane", "A12342"), book1);
    library.addAsset(new Librarian("Jane", "A12342"), book2);
    library.checkOutItem(book1, classUnderTest);
    library.checkOutItem(book2, classUnderTest);

    // Act & Assert
    assertThat(classUnderTest.getCheckedOutBooks(library)).isEqualTo(expectedBooks);
  }
  
  @Test
  void testMultipleLibraries(){
    //Arrange
    Library library1 = new Library("other library1");
    Library library2 = new Library("other library2");
    classUnderTest.addLibrary(library);
    classUnderTest.addLibrary(library1);
    classUnderTest.addLibrary(library2);


    //Assert
    assertThat(classUnderTest.libraries.containsValue(library1));
    assertThat(classUnderTest.libraries.containsValue(library2));
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Patron{id='johndoe@example.com', name='John Doe'}");
  }
}
