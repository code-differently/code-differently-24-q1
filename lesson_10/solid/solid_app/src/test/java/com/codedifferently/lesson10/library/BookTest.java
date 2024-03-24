package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

  private Book classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest =
        new Book("To Kill a Mockingbird", "978-0061120084", List.of("Harper Lee"), 281);
    library = mock(Library.class);
    when(library.getId()).thenReturn("Library 1");
    when(library.hasMediaItem(classUnderTest)).thenReturn(true);
    classUnderTest.setLibrary(library);
  }

  @Test
  void testPatron_created() {
    // Assert
    assertThat(classUnderTest.getTitle()).isEqualTo("To Kill a Mockingbird");
    assertThat(classUnderTest.getIsbn()).isEqualTo("978-0061120084");
    assertThat(classUnderTest.getAuthors()).isEqualTo(List.of("Harper Lee"));
    assertThat(classUnderTest.getNumberOfPages()).isEqualTo(281);
  }

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = mock(Library.class);
    when(otherLibrary.hasMediaItem(classUnderTest)).thenReturn(false);
    when(otherLibrary.getId()).thenReturn("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Item To Kill a Mockingbird is not in library Library 2");
  }

  @Test
  void testIsCheckedOut_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for item To Kill a Mockingbird");
  }

  @Test
  void testIsCheckedOut() {
    // Arrange
    when(library.isCheckedOut(classUnderTest)).thenReturn(true);

    // Act & Assert
    assertThat(classUnderTest.isCheckedOut()).isTrue();
  }

  @Test
  void testIsCheckedOut_whenNotCheckedOut() {
    // Arrange
    when(library.isCheckedOut(classUnderTest)).thenReturn(false);

    // Act & Assert
    assertThat(classUnderTest.isCheckedOut()).isFalse();
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Book{id='To Kill a Mockingbird', title='To Kill a Mockingbird'}");
  }
}
