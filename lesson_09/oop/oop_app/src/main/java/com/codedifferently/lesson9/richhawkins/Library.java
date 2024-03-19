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
    patrons.add(patron);
  }
}
