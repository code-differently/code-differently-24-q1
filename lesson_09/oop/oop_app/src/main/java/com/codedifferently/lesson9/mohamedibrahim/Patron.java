package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Patron {
  private String name;
  private int id;
  private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

  /**
   * takes in the name and id# of a patron
   *
   * @param name name of a person
   * @param id a unique id for the person
   */
  public Patron(String name, int id) {
    this.name = name;
    this.id = id;
  }

  /**
   * takes in the name and sets it for this patron
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * takes in the library that the patron is borrowing from and the book they are borrowing
   *
   * @param library implemented to use the check out book fuction in the library class
   * @param book implemented to look for the book that they want to borrow
   */
  public void checkOutBook(Library library, Book book) {
    checkedOutBooks.add(library.checkOutBook(book));
  }

  /**
   * takes in the library that the patron is borrowing from and the books they are borrowing
   *
   * @param library implemented to use the check out book fuction in the library class
   * @param book implemented to look for the books that they want to borrow
   */
  public void checkOutBook(Library library, ArrayList<Book> book) {
    checkedOutBooks.addAll(library.checkOutBook(book));
  }

  /**
   * gets the patron name and returns it
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * gets the array list that countains books and returns it
   *
   * @return Book
   */
  public ArrayList<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * Gets the id and returns it
   *
   * @return int
   */
  public int getId() {
    return id;
  }
}
