package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MagazineTest {

  private Magazine classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Magazine("TIME: Java", "978-0061520084");
    library = mock(Library.class);
    when(library.getId()).thenReturn("Library 1");
    when(library.hasAsset(classUnderTest)).thenReturn(true);
    classUnderTest.setLibrary(library);
  }

  @Test
  void testItem_created() {
    // Assert
    assertThat(classUnderTest.getTitle()).isEqualTo("TIME: Java");
    assertThat(classUnderTest.getIsbn()).isEqualTo("978-0061520084");
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
        .hasMessageContaining("Item 978-0061520084 is not in library Library 2");
  }

  @Test
  void testToString() {
    // Act & Assert
    assertThat(classUnderTest.toString())
        .isEqualTo("Item{id='978-0061520084', title='TIME: Java'}");
  }
}
