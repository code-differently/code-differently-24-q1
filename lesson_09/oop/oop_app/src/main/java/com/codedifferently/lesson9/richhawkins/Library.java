package main.java.com.codedifferently.lesson9.richhawkins;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Library {
  private HashSet<Book> bookCollection = new HashSet<>();
  private List<Patron> patrons = new ArrayList<>();

  public HashSet<Book> getBookCollection() {
    return bookCollection;
  }

  public List<Patron> getPatrons() {
    return patrons;
  }

  public void addBook(Book book) {
    bookCollection.add(book);
  }

  public void removeBook(Book book) {
    bookCollection.remove(book);
  }

  public void registerNewPatron(Patron patron) {
    if (patrons.contains(patron)) {
      throw new DuplicatePatronException("Error: This patron already exists.");
    }
    patrons.add(patron);
  }

  public void checkOutBook(Book book, Patron patron, Library library) {
    if (!book.getCheckedOut()
        && patrons.contains(patron)
        && library.bookCollection.contains(book)) {
      book.setCheckedOut(true);
      patron.getCheckedOutBooks().add(book.getTitle());
    } else {
      throw new AlreadyCheckedOutException("Book is already checked out.");
    }
  }

  public void checkBookIn(Book book, Patron patron, Library library) {
    if (book.getCheckedOut() && patrons.contains(patron) && library.bookCollection.contains(book)) {
      book.setCheckedOut(false);
      patron.getCheckedOutBooks().remove(book.getTitle());
    }
  }
}
