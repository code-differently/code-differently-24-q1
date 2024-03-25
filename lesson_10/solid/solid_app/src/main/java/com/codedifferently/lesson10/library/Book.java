package com.codedifferently.lesson10.library;

import java.util.List;
import java.util.Objects;

/** Represents a book. */
public class Book extends MediaItem {
  private String isbn;
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
  }

  /** Get the ISBN of the book. */
  public String getIsbn() {
    return isbn;
  }

  /** Get the authors of the book. */
  public List<String> getAuthors() {
    return authors;
  }

  /** Get the number of pages in the book. */
  public int getNumberOfPages() {
    return numberOfPages;
  }

  @Override
  public boolean canCheckOut() {
    System.out.println("Enjoy your book!");
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return Objects.equals(getIsbn(), book.getIsbn());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Book{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
