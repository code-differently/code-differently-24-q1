package com.codedifferently.lesson9.JadasLibrary;

import java.util.ArrayList;
import java.util.List;

public class Jadaslibrary {
  private List<Book> books;
  private List<Patron> patrons;

  public Jadaslibrary() {
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void registerPatron(Patron patron) {
    patrons.add(patron);
  }

  public void checkOutBook(Book book, Patron patron) {
    if (books.contains(book) && !book.isCheckedOut()) {
      book.setCheckedOut(true);
      patron.getCheckedOutBooks().add(book);
    }
  }

  public void returnBook(Book book, Patron patron) {
    if (patron.getCheckedOutBooks().contains(book)) {
      book.setCheckedOut(false);
      patron.getCheckedOutBooks().remove(book);
    }
  }

  public List<Book> getBooks() {
    return new ArrayList<>(books);
  }

  public List<Patron> getPatrons() {
    return new ArrayList<>(patrons);
  }
}
