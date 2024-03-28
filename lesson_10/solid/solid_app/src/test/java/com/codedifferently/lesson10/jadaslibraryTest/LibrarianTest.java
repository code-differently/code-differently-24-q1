package test.java.com.codedifferently.lesson10.jadaslibraryTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson10.jadaslibrary.Book;
import com.codedifferently.lesson10.jadaslibrary.Jadaslibrary;
import com.codedifferently.lesson10.jadaslibrary.Librarian;
import java.util.List;
import org.junit.jupiter.api.Test;

public class LibrarianTest {

  @Test
  public void testAddBookToLibrary() {

    Jadaslibrary library = new Jadaslibrary("library1");
    Librarian librarian = new Librarian("Sally May");
    Book book = new Book("The Bluest Eye", "978-0140088298", List.of("Toni Morrison"), 226);

    librarian.addBookToLibrary(book, library);

    assertTrue(library.getBooks().contains(book));
  }

  @Test
  public void testRemoveBookFromLibrary() {

    Jadaslibrary library = new Jadaslibrary("library1");
    Librarian librarian = new Librarian("Jada White");
    Book book =
        new Book("The Women of Brewster Place", "978-0674932456", List.of("Gloria Naylor"), 192);
    library.addBook(book);

    librarian.removeBookFromLibrary(book, library);

    assertFalse(library.getBooks().contains(book));
  }
}
