package com.codedifferently.lesson9.kevinmason;

import java.util.ArrayList;
import java.util.List;

public class Library {
  private List<Book> books;
  private List<Patron> patrons;

  public Library() {
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
    if (!book.isCheckedOut()) {
      book.setCheckedOut(true);
      patron.addCheckedOutBook(book);
    }
  }

  public void returnBook(Book book, Patron patron) {
    book.setCheckedOut(false);
    patron.removeCheckedOutBook(book);
  }

  public List<Book> getBooks() {
    return books;
  }
}
