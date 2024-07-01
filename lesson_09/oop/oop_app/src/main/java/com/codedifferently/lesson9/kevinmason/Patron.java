package com.codedifferently.lesson9.kevinmason;

import java.util.ArrayList;
import java.util.List;

public class Patron {
  private String name;
  private List<Book> checkedOutBooks;

  public Patron(String name) {
    this.name = name;
    this.checkedOutBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void addCheckedOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  public void removeCheckedOutBook(Book book) {
    checkedOutBooks.remove(book);
  }
}
