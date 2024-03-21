import com.codedifferently.lesson10.library.Library;
import com.codedifferently.lesson10.library.Patron;

public class Librarian extends Patron {

  private Library library;
  private String book;

  public Librarian(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public void Patron(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Librarian(Library library, String book, boolean CheckedOut) {
    this.library = library;
    this.book = book;
  }

public void addBook() {
   book.add();
}

public void removeBook() {
  book.remove();
} 
}