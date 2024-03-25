package test.java.com.codedifferently.lesson10.library;
test.java.com.codedifferently.lesson10.library.Librarian;
import com.codedifferently.lesson10.library.Book;
import com.codedifferently.lesson10.library.Library;
import com.codedifferently.lesson10.library.Patron;

public class LibrarianTest {

    @Test
    void testLibrarianCreation() {
        // Arrange
        String name = "Alice";
        String email = "alice@example.com";
        Library library = new Library("Library 1");

        // Act
        Librarian librarian = new Librarian(name, email, library);

        // Assert
        assertNotNull(librarian);
        assertEquals(name, librarian.getName());
        assertEquals(email, librarian.getId());
        assertEquals(library, librarian.getLibrary());
    }

    private void assertNotNull(Librarian librarian) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertNotNull'");
    }
}
