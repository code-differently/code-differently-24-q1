package com.codedifferently.lesson10.library;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.MagazineCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public class MagazineTest {

    private Magazine classUnderTest;
    private Library library;

    @BeforeEach
    void setUp() {
        classUnderTest = new Magazine("Vogue", 123456);
        library = mock(Library.class);
        when(library.hasMagazine(classUnderTest)).thenReturn(true);
        classUnderTest.setLibrary(library);
    }

    @Test
    void testMagazine_created() {
        assertThat(classUnderTest.getTitle()).isEqualTo("Vogue");
        assertThat(classUnderTest.getIssn()).isEqualTo(123456);
    }

    @Test
    void testSetLibrary_WrongLibrary() throws WrongLibraryException {
        Library otherLibrary = mock(Library.class);
        when(otherLibrary.hasMagazine(classUnderTest)).thenReturn(false);

        assertThatThrownBy(() -> classUnderTest.setLibrary(otherLibrary))
                .isInstanceOf(WrongLibraryException.class)
                .hasMessageContaining("Magazine 123456 is not in library");
    }

    @Test
    void testIsCheckedOut_LibraryNotSet() {
        classUnderTest.setLibrary(null);
    
        assertThatThrownBy(() -> classUnderTest.isMagazineCheckedOut())
                .isInstanceOf(LibraryNotSetException.class)
                .hasMessageContaining("Library not set for Magazine 123456");
    }
    
    @Test
    void testIsMagazineCheckedOut() {
        // Assert that trying to check out the magazine throws the expected exception
        assertThatThrownBy(() -> classUnderTest.isMagazineCheckedOut())
                .isInstanceOf(MagazineCheckedOutException.class)
                .hasMessageContaining("Sorry! Magazine cannot be checked out from the library.");
    }

    @Test
    void testToString() {
        assertThat(classUnderTest.toString())
                .isEqualTo("Magazine{issn='123456', title='Vogue'}");
    }
}

