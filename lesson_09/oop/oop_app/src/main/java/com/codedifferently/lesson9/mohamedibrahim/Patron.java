package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Patron {
  private String name;
  private int id;
  private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

  public Patron(String name, int id) {
    this.name = name;
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void checkOutBook(Library library, Book book) {
    checkedOutBooks.add(library.checkOutBook(book));
  }

  public void checkOutBook(Library library, ArrayList<Book> book) {
    checkedOutBooks.addAll(library.checkOutBook(book));
  }

  /**
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * @return Book
   */
  public ArrayList<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * @return int
   */
  public int getId() {
    return id;
  }
}
