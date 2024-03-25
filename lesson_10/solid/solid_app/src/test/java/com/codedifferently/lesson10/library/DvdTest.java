package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DvdTest {

  private Dvd classUnderTest;
  private Library library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Dvd("The Martian", 123456);
    library = mock(Library.class);
    when(library.hasDvd(classUnderTest)).thenReturn(true);
    classUnderTest.setLibrary(library);
  }

  @Test
  void testPatron_created() {
    assertThat(classUnderTest.getTitle()).isEqualTo("The Martian");
    assertThat(classUnderTest.getIssn()).isEqualTo(123456);
  }

  @Test
  void testSetLibrary_WrongLibrary() throws WrongLibraryException {
    Library otherLibrary = mock(Library.class);
    when(otherLibrary.hasDvd(classUnderTest)).thenReturn(false);

    assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Dvd 123456 is not in library");
  }

  @Test
  void testIsCheckedOut_LibraryNotSet() {
    classUnderTest.setLibrary(null);

    assertThatThrownBy(() -> classUnderTest.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessageContaining("Library not set for DVD 123456");
  }

  @Test
  void testIsCheckedOut() throws LibraryNotSetException {
    when(library.isCheckedOut(classUnderTest)).thenReturn(true);

    assertThat(classUnderTest.isCheckedOut()).isTrue();
  }

  @Test
  void testIsCheckedOut_whenNotCheckedOut() throws LibraryNotSetException {
    when(library.isCheckedOut(classUnderTest)).thenReturn(false);

    assertThat(classUnderTest.isCheckedOut()).isFalse();
  }

  @Test
  void testToString() {
    assertThat(classUnderTest.toString()).isEqualTo("Dvd{issn='123456', title='The Martian'}");
  }
}
