package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DvdTest {

  private Dvd classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Dvd("Book 2, Books Revenge The Movie", "978-0061620084");
    library = mock(Library.class);
    when(library.getId()).thenReturn("Library 1");
    when(library.hasAsset(classUnderTest)).thenReturn(true);
    classUnderTest.setLibrary(library);
  }

  @Test
  void testDvd_created() {
    // Assert
    assertThat(classUnderTest.getTitle()).isEqualTo("Book 2, Books Revenge The Movie");
    assertThat(classUnderTest.getIsbn()).isEqualTo("978-0061620084");
  }

  @Test
  void testSetLibrary_WrongLibrary() {
    // Arrange
    Library otherLibrary = mock(Library.class);
    when(otherLibrary.hasAsset(classUnderTest)).thenReturn(false);
    when(otherLibrary.getId()).thenReturn("Library 2");

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Item 978-0061620084 is not in library Library 2");
  }

  @Test
  void testIsCheckedOut_LibraryNotSet() {
    // Arrange
    classUnderTest.setLibrary(null);

    // Act & Assert
    assertThatThrownBy(() -> classUnderTest.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for item 978-0061620084");
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
        .isEqualTo("Item{id='978-0061620084', title='Book 2, Books Revenge The Movie'}");
  }
}
