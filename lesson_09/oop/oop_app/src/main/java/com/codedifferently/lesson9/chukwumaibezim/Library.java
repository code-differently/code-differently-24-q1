package com.codedifferently.lesson9.chukwumaibezim;

import java.util.ArrayList;
import java.util.HashSet;

public class Library {
  private HashSet<Book> books;
  private ArrayList<Patron> patrons;

  public Library() {
    this.books = new HashSet<>();
    this.patrons = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void addPatron(Patron patron) {
    patrons.add(patron);
  }

  public void removePatron(Patron patron) {
    patrons.remove(patron);
  }

  public void checkOutBook(Book book, Patron patron) {
    if (books.contains(book) && !book.isCheckedOut()) {
      patron.checkOutBook(book);
    }
  }

  public void checkInBook(Book book, Patron patron) {
    if (patron.getCheckedOutBooks().contains(book)) {
      patron.checkInBook(book);
    }
  }

  public void returnBook(Book book1, Patron patron) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
  }
}
