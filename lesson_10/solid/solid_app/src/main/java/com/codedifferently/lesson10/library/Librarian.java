package com.codedifferently.lesson10.library;

public class Librarian extends Patron {
  private Library library;

  public Librarian(String name, String email, Library library) {
    super(name, email);
    this.library = library;
  }

  public void addBook(Book book) {
    library.addBook(book);
  }

  public void removeBook(Book book) {
    library.removeBook(book);
  }
}
