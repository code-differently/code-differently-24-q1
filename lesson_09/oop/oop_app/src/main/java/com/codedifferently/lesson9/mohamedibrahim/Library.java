package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Library {
  private ArrayList<Book> shelves = new ArrayList<Book>();
  private ArrayList<Integer> currentPatronIds = new ArrayList<Integer>();
  private ArrayList<Patron> currentPatrons = new ArrayList<Patron>();
  private ArrayList<Integer> usedIsbins = new ArrayList<Integer>();

  public Library() {}

  public Library(ArrayList<Book> shelves) {
    this.shelves = shelves;
  }

  public ArrayList<Patron> getCurrentPatrons() {
    return currentPatrons;
  }

  public ArrayList<Integer> getCurrentPatronIds() {
    return currentPatronIds;
  }

  public ArrayList<Book> getBooks() {
    return shelves;
  }

  /**
   * @param book
   */
  public void addBooks(Book book) {
    usedIsbins.add(book.getIsbn());
    shelves.add(book);
  }

  /**
   * @param book
   */
  public void checkInBook(Book book) {
    addBooks(book);
  }

  /**
   * @param patron
   */
  public void registerPatron(Patron patron) {
    if (currentPatronIds.contains(patron.getId())) {
      throw new UserAlreadyRegistered("This User ID is In Use!");
    }
    currentPatronIds.add(patron.getId());
    currentPatrons.add(patron);
  }

  /**
   * @param book
   * @return
   */
  public Book checkOutBook(Book book) {
    if (shelves.contains(book)) {
      book.isCheckedOut();
      shelves.remove(book);
      return book;
    } else {
      throw new BookNotFound("Error Book not Found!");
    }
  }

  /**
   * @param books
   * @return
   */
  public ArrayList<Book> checkOutBook(ArrayList<Book> books) {
    if (shelves.containsAll(books)) {
      for (Book b : books) {
        b.isCheckedOut();
      }
      shelves.removeAll(books);
      return books;
    } else {
      throw new BookNotFound("Error Book not Found!");
    }
  }
}
