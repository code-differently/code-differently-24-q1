package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Patron {
  private String name;
  private int id;
  private ArrayList<Book> checkedOutBooks = new ArrayList<Book>();

  /**
   * Takes in the name and id# of a patron.
   *
   * @param name Name of a person.
   * @param id A unique id for the person.
   */
  public Patron(String name, int id) {
    this.name = name;
    this.id = id;
  }

  /**
   * Takes in the name and sets it for this patron.
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Takes in the library that the patron is borrowing from and the book they are borrowing.
   *
   * @param library Implemented to use the check out book fuction in the library class.
   * @param book Implemented to look for the book that they want to borrow.
   */
  public void checkOutBook(Library library, Book book) {
    checkedOutBooks.add(library.checkOutBook(book));
  }

  /**
   * Takes in the library that the patron is borrowing from and the books they are borrowing.
   *
   * @param library Implemented to use the check out book fuction in the library class.
   * @param book Implemented to look for the books that they want to borrow.
   */
  public void checkOutBooks(Library library, ArrayList<Book> book) {
    checkedOutBooks.addAll(library.checkOutBooks(book));
  }

  public void checkInBook(Library library, Book book) {
    checkedOutBooks.remove(book);
    library.checkInBook(book, library);
  }

  public void checkInBooks(Library library, ArrayList<Book> books) {
    for (Book b : books) {
      library.checkInBook(b, library);
    }
    checkedOutBooks.removeAll(books);
  }

  /**
   * Gets the patron name and returns it.
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Gets the array list that countains books and returns it.
   *
   * @return Book
   */
  public ArrayList<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  /**
   * Gets the id and returns it.
   *
   * @return int
   */
  public int getId() {
    return id;
  }
}
