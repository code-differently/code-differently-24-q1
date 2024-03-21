package com.codedifferently.lesson9.JadasLibrary;

import java.util.ArrayList;
import java.util.List;

public class PatronImpl implements Patron {
  private String name;
  private List<Book> checkedOutBooks;

  public PatronImpl(String name) {
    this.name = name;
    this.checkedOutBooks = new ArrayList<>();
  }

  @Override
  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  @Override
  public void returnBook(Book book) {
    checkedOutBooks.remove(book);
  }

  @Override
  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  @Override
  public String getName() {
    return name;
  }
}
