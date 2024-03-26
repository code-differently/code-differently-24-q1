package com.codedifferently.lesson9.natayaprice;

import java.util.ArrayList;
import java.util.List;

public class Library {

  private List<Book> books;
  private List<Patron> patrons;

  public Library() {
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
  }

  public void registerPatron(Patron patron) {
    patrons.add(patron);
  }

  public List<Patron> getPatrons() {
    return patrons;
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public List<Book> getBooks() {
    return books;
  }
}
