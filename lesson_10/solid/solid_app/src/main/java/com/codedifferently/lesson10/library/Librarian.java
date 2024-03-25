package com.codedifferently.lesson10.library;

public class Librarian extends Patron {

  public Librarian(String name, String email) {
    super(name, email);
  }

  public void addBook(Library library, Book book) {
    library.addBook(book);
    System.out.println(
        "Librarian " + this.getName() + " added the book: " + book.getTitle() + " to the library.");
  }

  public void removeBook(Library library, Book book) {
    library.removeBook(book);
    System.out.println(
        "Librarian "
            + this.getName()
            + " removed the book: "
            + book.getTitle()
            + " from the library.");
  }
}
