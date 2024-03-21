package com.codedifferently.lesson9.JadasLibraryTest;

import com.codedifferently.lesson9.JadasLibrary.Book;
import com.codedifferently.lesson9.JadasLibrary.Patron;
import java.util.ArrayList;
import java.util.List;

public class ConcretePatronTest implements Patron {
  private String name;
  private List<Book> checkedOutBooks;

  public ConcretePatronTest(String name) {
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
    return new ArrayList<>(checkedOutBooks);
  }

  @Override
  public String getName() {
    return name;
  }
}
