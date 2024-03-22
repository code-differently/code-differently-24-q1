package com.codedifferently.lesson9.jamira;

import java.util.ArrayList;
import java.util.List;

public class Library {
  private List<Book> books;
  private List<Patron> patrons;

  // Constructor
  public Library() {
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
  }

  // Getters and setters
  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public List<Patron> getPatrons() {
    return patrons;
  }

  public void setPatrons(List<Patron> patrons) {
    this.patrons = patrons;
  }

  public void removeBook(Book bookToRemove) {
    this.books.remove(bookToRemove);
  }

  public void addBook(Book newBook) {
    this.books.add(newBook);
  }

  // Methods to add/remove books, register new patrons, check out and return books
  // Add appropriate methods as needed...
}
