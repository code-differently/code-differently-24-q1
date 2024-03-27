package test.java.com.codedifferently.lesson10.jadaslibraryTest;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson10.jadaslibrary.Book;
import com.codedifferently.lesson10.jadaslibrary.Jadaslibrary;
import com.codedifferently.lesson10.jadaslibrary.Librarian;
import com.codedifferently.lesson10.jadaslibrary.Magazine;
import com.codedifferently.lesson10.jadaslibrary.Patron;
import com.codedifferently.lesson10.jadaslibrary.exceptions.WrongLibraryException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JadaslibraryTest {
  private Jadaslibrary classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Jadaslibrary("Library 1");
  }

  @Test
  void testAddBookToLibrary() {
    Book book1 = new Book("The Bluest Eye", "978-0140088298", List.of("Toni Morrison"), 226);
    Book book2 = new Book("Sula", "978-0452260108", List.of("Toni Morrison"), 193);
    classUnderTest.addBook(book1);
    classUnderTest.addBook(book2);
    assertThat(classUnderTest.hasBook(book1)).isTrue();
    assertThat(classUnderTest.hasBook(book2)).isTrue();
  }

  @Test
  void testRemoveBookFromLibrary() {
    Book book1 = new Book("The Bluest Eye", "978-0140088298", List.of("Toni Morrison"), 226);
    Book book2 = new Book("Sula", "978-0452260108", List.of("Toni Morrison"), 193);
    classUnderTest.addBook(book1);
    classUnderTest.addBook(book2);
    classUnderTest.removeBook(book1);
    classUnderTest.removeBook(book2);
    assertThat(classUnderTest.hasBook(book1)).isFalse();
    assertThat(classUnderTest.hasBook(book2)).isFalse();
  }

  @Test
  void testRegisterPatron() {
    Patron patron1 = new Patron("Stacy Law", "StacyLaw@gmail.com");
    Patron patron2 = new Patron("Clay Brown", "ClayBrown@gmail.com");
    classUnderTest.registerPatron(patron1);
    classUnderTest.registerPatron(patron2);
    assertThat(classUnderTest.getPatrons()).containsExactly(patron1, patron2);
  }

  @Test
  void testRemovePatron() {
    Patron patron1 = new Patron("Stacy Law", "StacyLaw@gmail.com");
    Patron patron2 = new Patron("Clay Brown", "ClayBrown@gmail.com");
    classUnderTest.registerPatron(patron1);
    classUnderTest.registerPatron(patron2);
    classUnderTest.removePatron(patron1);
    classUnderTest.removePatron(patron2);
    assertThat(classUnderTest.getPatrons()).isEmpty();
  }

  @Test
  void testCheckOutBook() throws WrongLibraryException {
    Book book = new Book("Liden Hills", "978-3293006853", List.of("Gloria Naylor"), 320);
    Patron patron = new Patron("Clay Brown", "ClayBrown@gmail.com");
    classUnderTest.addBook(book);
    classUnderTest.registerPatron(patron);
    classUnderTest.checkOutBook(book, patron);
    assertThat(classUnderTest.isCheckedOut(book)).isTrue();
    assertThat(patron.getCheckedOutBooks()).containsExactly(book);
  }

  @Test
  void testReturnBook() throws WrongLibraryException {
    Book book = new Book("Nobody Knows My Name", "978-0679744733", List.of("James Baldwin"), 256);
    Patron patron = new Patron("Stacy Law", "StacyLaw@gmail.com");
    classUnderTest.addBook(book);
    classUnderTest.registerPatron(patron);
    classUnderTest.checkOutBook(book, patron);
    classUnderTest.returnMediaItem(book);
    assertThat(classUnderTest.isCheckedOut(book)).isFalse();
    assertThat(patron.getCheckedOutBooks()).isEmpty();
  }

  @Test
  void testLibrarianAddBook() throws WrongLibraryException {
    Librarian librarian = new Librarian("Sally May");
    Book book = new Book("God Help the child", "978-0349016177", List.of("Toni Morrison"), 139);
    librarian.addBookToLibrary(book, classUnderTest);
    assertThat(classUnderTest.getBooks()).containsExactly(book);
  }

  @Test
  void testLibrarianRemoveBook() throws WrongLibraryException {
    Book book =
        new Book("The Women of Brewster Place", "978-0674932456", List.of("Gloria Naylor"), 192);
    classUnderTest.addBook(book);
    Librarian librarian = new Librarian("Sally May");
    librarian.removeBookFromLibrary(book, classUnderTest);
    assertThat(classUnderTest.getBooks()).isEmpty();
  }

  @Test
  void testPatronCannotCheckOutMagazine() throws WrongLibraryException {
    Patron patron = new Patron("Anthony Mays", "AnthonyMays@gmail.com");
    Magazine magazine = new Magazine("National Geographic", "Publisher Name", "2022-03", 1, 1);
    classUnderTest.addMediaItem(magazine);
    classUnderTest.registerPatron(patron);
    classUnderTest.checkOutMediaItem(magazine, patron);
  }
}
