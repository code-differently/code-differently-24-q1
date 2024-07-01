package com.codedifferently.lesson9.jamira;

import java.util.List;

public class Patron {
  private String name;
  private List<Book> checkedOutBooks;

  public Patron(String name, List<Book> checkedOutBooks) {
    this.name = name;
    this.checkedOutBooks = checkedOutBooks;
  }

  public String getName() {
    return name;
  }

  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void addCheckedOutBook(Book newBook) {
    checkedOutBooks.add(newBook);
  }
}
