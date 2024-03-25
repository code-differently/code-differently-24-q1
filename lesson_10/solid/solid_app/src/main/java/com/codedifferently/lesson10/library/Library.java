package com.codedifferently.lesson10.library;

import java.util.HashMap;
import java.util.Map;

public class Library {
  private Map<String, Book> books = new HashMap<>();

  public void addBook(Book book) {
    books.put(book.getISBN(), book);
  }

  // Other methods and properties of Library class...
}
