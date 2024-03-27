package com.codedifferently.lesson10.library;

import java.util.List;
import java.util.UUID;

/** Represents a book in the library. */
class Book extends MediaItem {
  private List<String> authors;
  private int numberOfPages;
  private String isbn;

  /**
   * Creates a new book.
   *
   * @param uuid the UUID of the book
   * @param title the title of the book
   * @param authors the authors of the book
   * @param numberOfPages the number of pages in the book
   * @param isbn the ISBN of the book
   */
  public Book(UUID uuid, String title, List<String> authors, int numberOfPages, String isbn) {
    super(uuid, title, "Book");
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.isbn = isbn;
  }

  /**
   * Gets the authors of the book.
   *
   * @return the authors of the book
   */
  public List<String> getAuthors() {
    return authors;
  }

  /**
   * Gets the number of pages in the book.
   *
   * @return the number of pages in the book
   */
  public int getNumberOfPages() {
    return numberOfPages;
  }

  /**
   * Gets the ISBN of the book.
   *
   * @return the ISBN of the book
   */
  public String getIsbn() {
    return isbn;
  }

  @Override
  public String toString() {
    return "Book{"
        + "title='"
        + getTitle()
        + '\''
        + ", authors="
        + authors
        + ", numberOfPages="
        + numberOfPages
        + ", uuid="
        + getUUID()
        + '}';
  }
}
