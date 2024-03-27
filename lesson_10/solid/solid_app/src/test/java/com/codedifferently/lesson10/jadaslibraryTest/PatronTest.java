package test.java.com.codedifferently.lesson10.jadaslibraryTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson10.jadaslibrary.Book;
import com.codedifferently.lesson10.jadaslibrary.Dvd;
import com.codedifferently.lesson10.jadaslibrary.Jadaslibrary;
import com.codedifferently.lesson10.jadaslibrary.Patron;
import com.codedifferently.lesson10.jadaslibrary.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.jadaslibrary.exceptions.WrongLibraryException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PatronTest {
  private Patron classUnderTest;
  private Jadaslibrary library;

  @BeforeEach
  void setUp() {
    classUnderTest = new Patron("Clay Brown", "ClayBrown@gmail.com");
    library = new Jadaslibrary("Library 1");
    library.addPatron(classUnderTest);
  }

  @Test
  void testSetLibrary() throws WrongLibraryException {
    assertThat(classUnderTest.getLibrary()).isNull();
    classUnderTest.setLibrary(library);
    assertThat(classUnderTest.getLibrary()).isEqualTo(library);
  }

  @Test
  void testGetCheckedOutBooks() throws LibraryNotSetException {
    Book book1 = new Book("The Bluest Eye", "978-0140088298", List.of("Toni Morrison"), 226);
    Book book2 = new Book("Sula", "978-0452260108", List.of("Toni Morrison"), 193);
    Set<Book> expectedBooks = new HashSet<>();
    expectedBooks.add(book1);
    expectedBooks.add(book2);

    library.addBook(book1);
    library.addBook(book2);
    library.checkOutMediaItem(book1, classUnderTest);
    library.checkOutMediaItem(book2, classUnderTest);
    assertThat(classUnderTest.getCheckedOutBooks()).isEqualTo(expectedBooks);
  }

  @Test
  void testReturnDvd() throws LibraryNotSetException {
    Dvd dvd = new Dvd("Movie Title", "Director Name", 2000);
    library.addMediaItem(dvd);
    library.checkOutMediaItem(dvd, classUnderTest);
    classUnderTest.returnMediaItem(dvd);
    assertThat(dvd.isCheckedOut()).isFalse();
    assertThat(dvd.getPatron()).isNull();
  }

  @Test
  void testToString() {
    assertThat(classUnderTest.toString())
        .isEqualTo("Patron{id='ClayBrown@gmail.com', name='Clay Brown'}");
  }
}
