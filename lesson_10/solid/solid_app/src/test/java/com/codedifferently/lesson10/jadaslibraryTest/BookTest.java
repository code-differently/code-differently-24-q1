package test.java.com.codedifferently.lesson10.jadaslibraryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

import com.codedifferently.lesson10.jadaslibrary.Book;
import com.codedifferently.lesson10.jadaslibrary.Jadaslibrary;
import com.codedifferently.lesson10.jadaslibrary.exceptions.WrongLibraryException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
  private Book book;
  private Jadaslibrary library;

  @BeforeEach
  void setUp() {
    book = new Book("The Bluest Eye", "978-0140088298", List.of("Toni Morrison"), 226);
    library = mock(Jadaslibrary.class);
    when(library.getId()).thenReturn("Library 1");
    when(library.hasBook(book)).thenReturn(true);
    book.setLibrary(library);
  }

  @Test
  void testBookCreation() {
    // Assertions for Book attributes
    assertThat(book.getTitle()).isEqualTo("The Bluest Eye");
    assertThat(book.getIsbn()).isEqualTo("978-0140088298");
    assertThat(book.getAuthor()).isEqualTo("Toni Morrison");
    assertThat(book.getNumberOfPages()).isEqualTo(226);
  }

  @Test
  void testSetLibraryWithWrongLibrary() {
    Jadaslibrary otherLibrary = mock(Jadaslibrary.class);
    when(otherLibrary.hasBook(book)).thenReturn(false);
    assertThatThrownBy(() -> book.setLibrary(otherLibrary))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessageContaining("Book 978-0140088298 is not in library");
  }

  @Test
  void testIsCheckedOut() {
    when(library.isCheckedOut(book)).thenReturn(true);
    assertThat(book.isCheckedOut()).isTrue();
  }

  @Test
  void TestIsNotCheckedOut() {
    when(library.isCheckedOut(book)).thenReturn(false);
    assertThat(book.isCheckedOut()).isFalse();
  }
}
