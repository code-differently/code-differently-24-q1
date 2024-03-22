package com.codedifferently.lesson10.library;

import java.util.List;

/** Represents a book. */
public class Book extends LibraryAsset {
  private List<String> authors;
  private int numberOfPages;

  /**
   * Create a new book with the given title, ISBN, authors, and number of pages.
   *
   * @param title The title of the book.
   * @param isbn The ISBN of the book.
   * @param authors The authors of the book.
   * @param numberOfPages The number of pages in the book.
   */
  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.canCheckOut = true;
  }

  /**
   * Get the authors of the book.
   *
   * @return List<String> Returns a list of authors for the book.
   */
  public List<String> getAuthors() {
    return authors;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }
}
