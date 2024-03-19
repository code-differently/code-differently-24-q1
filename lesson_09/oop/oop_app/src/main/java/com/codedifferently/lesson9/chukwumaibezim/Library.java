package com.codedifferently.lesson9.chukwumaibezim;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Library class
 */
public class Library {
  private HashSet<Book> books;
  private ArrayList<Patron> patrons;

  /**
   * Constructor for Library
   */
  public Library() {
    this.books = new HashSet<>();
    this.patrons = new ArrayList<>();
  }

  /**
   * Getters and Setters
   * @return
   */
  public void addBook(Book book) {
    books.add(book);
  }

  /**
   * Add book to library
   * @param book
   */
  public void removeBook(Book book) {
    books.remove(book);
  }

  /**
   * Remove book from library
   * @param book
   */
  public void addPatron(Patron patron) {
    patrons.add(patron);
  }

  /**
   * Add patron to library
   * @param patron
   */
  public void removePatron(Patron patron) {
    patrons.remove(patron);
  }

  /**
   * Remove patron from library
   * @param patron
   */
  public void checkOutBook(Book book, Patron patron) {
    if (books.contains(book) && !book.isCheckedOut()) {
      patron.checkOutBook(book);
    }
  }

  /**
   * Check out book
   * @param book
   * @param patron
   */
  public void checkInBook(Book book, Patron patron) {
    if (patron.getCheckedOutBooks().contains(book)) {
      patron.checkInBook(book);
    }
  }

  /**
   * Check in book
   * @param book
   * @param patron
   */
  public void returnBook(Book book1, Patron patron) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
  }
}
