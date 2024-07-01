package com.codedifferently.lesson9.chukwumaibezim;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/** Library class */
public class Library {
  private HashSet<Book> books;
  private ArrayList<Patron> patrons;

  /** Constructor for Library */
  public Library() {
    this.books = new HashSet<>();
    this.patrons = new ArrayList<>();
  }

  /**
   * Getters and Setters
   *
   * @return
   */
  public void addBook(Book book) {
    books.add(book);
  }

  /**
   * Remove book from library
   *
   * @param book
   */
  public void removeBook(Book book) {
    books.remove(book);
  }

  /**
   * Add patron to library
   *
   * @param patron
   */
  public void addPatron(Patron patron) {
    patrons.add(patron);
  }

  /**
   * Checks to see if book is in library, if so, checks out book
   *
   * @param book
   * @param patron
   */
  public void checkOutBook(Book book, Patron patron) {
    if (books.contains(book) && !book.isCheckedOut()) {
      patron.performCheckout(book);
      book.checkOut();
    }
  }

  /**
   * Checks to see if book is in library, if so, checks in book
   *
   * @param book
   * @param patron
   */
  public void returnBook(Book book, Patron patron) {
    if (patron.getCheckedOutBooks().contains(book)) {
      patron.performCheckIn(book);
      book.checkIn();
    }
  }

  /**
   * Checks if two libraries are equal by comparing their books and patrons collections.
   *
   * @param obj The object to compare with this library.
   * @return True if the libraries are equal, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Library library = (Library) obj;
    return Objects.equals(books, library.books) && Objects.equals(patrons, library.patrons);
  }

  /**
   * Generates a hash code value for the library based on its books and patrons collections.
   *
   * @return The hash code value for the library.
   */
  @Override
  public int hashCode() {
    return Objects.hash(books, patrons);
  }
}
