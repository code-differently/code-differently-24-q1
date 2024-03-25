package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.NewspaperCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class NewspaperTest {

    private Newspaper classUnderTest;
    private Library library;

    @BeforeEach
    void setUp() {
        classUnderTest = new Newspaper("The New York Times", 123456);
        library = mock(Library.class);
        when(library.hasNewspaper(classUnderTest)).thenReturn(true);
        classUnderTest.setLibrary(library);
    }

    @Test
    void testNewspaper_created() {
        assertThat(classUnderTest.getTitle()).isEqualTo("The New York Times");
        assertThat(classUnderTest.getIssn()).isEqualTo(123456);
    }

    @Test
    void testSetLibrary_WrongLibrary() throws WrongLibraryException {
        Library otherLibrary = mock(Library.class);
        when(otherLibrary.hasNewspaper(classUnderTest)).thenReturn(false);

        assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
                .isInstanceOf(WrongLibraryException.class)
                .hasMessageContaining("Newspaper 123456 is not in library");
    }
 
    @Test
void testIsCheckedOut_LibraryNotSet() {
    classUnderTest.setLibrary(null);
    
    assertThatThrownBy(() -> classUnderTest.isNewspaperCheckedOut())
            .isInstanceOf(LibraryNotSetException.class)
            .hasMessageContaining("Library not set for Newspaper 123456");
}

    

    @Test
    void testIsNewspaperCheckedOut() {
        assertThatThrownBy(() -> classUnderTest.isNewspaperCheckedOut())
                .isInstanceOf(NewspaperCheckedOutException.class)
                .hasMessageContaining("Sorry! Newspaper cannot be checked out from the library.");
    }

    @Test
    void testToString() {
        assertThat(classUnderTest.toString())
                .isEqualTo("Newspaper{issn='123456', title='The New York Times'}");
    }
}