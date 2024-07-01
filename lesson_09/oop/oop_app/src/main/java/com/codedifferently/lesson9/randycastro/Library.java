package com.codedifferently.lesson9.randycastro;

import java.util.HashMap;
import java.util.Map;

public class Library {
  // Map to store books by ISBN
  private Map<String, Book> booksbyISBN;
  // Map to store patrons by ID
  private Map<String, Patron> patronsID;

  {
    this.booksbyISBN = new HashMap<>();
    this.patronsID = new HashMap<>();
  }

  // add book
  public void addBook(String isbn, Book book) {
    booksbyISBN.put(isbn, book);
  }

  // remove book
  public void removeBook(String isbn) {
    booksbyISBN.remove(isbn);
  }

  // Getters and Setters
  public Book getBookByISBN(String isbn) {
    Book book = booksbyISBN.get(isbn);
    if (book != null && !book.getCheckedout()) {
      return book;
    } else {
      return null;
    }
  }
}
