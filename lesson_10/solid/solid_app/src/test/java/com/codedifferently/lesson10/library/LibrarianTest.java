package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibrarianTest {

    private Librarian librarian;
    private Patron patron1;
    private Patron patron2;

    @Before
    public void setUp() {
        librarian = new Librarian("Libarian");
        patron1 = new Patron("patron1");
        patron2 = new Patron("patron2");
    }

    @Test
    public void testAddAndRemoveMediaItem() {
        librarian.addMediaItem("book", MediaTypes.BOOK);
        librarian.addMediaItem("dvd", MediaTypes.DVD);
        librarian.addMediaItem("magazine", MediaTypes.MAGAZINE);
        librarian.addMediaItem("newspaper", MediaTypes.NEWSPAPER);

        assertEquals(4, librarian.getMediaItems().size());

        librarian.removeMediaItem(librarian.getMediaItems().get(0));
        assertEquals(3, librarian.getMediaItems().size());
    }
    
}
