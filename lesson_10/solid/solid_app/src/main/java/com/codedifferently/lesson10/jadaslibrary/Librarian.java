package com.codedifferently.lesson10.jadaslibrary;

public class Librarian {
  private String name;

  public Librarian(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addBookToLibrary(Book book, Jadaslibrary library) {
    library.addBook(book);
  }

  public void removeBookFromLibrary(Book book, Jadaslibrary library) {
    library.removeBook(book);
  }
}
