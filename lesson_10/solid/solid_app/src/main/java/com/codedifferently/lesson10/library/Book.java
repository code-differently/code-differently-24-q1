package com.codedifferently.lesson10.library;

import java.util.List;
import java.util.Objects;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

/** Represents a book. */
public class Book implements Media {

  @Override
  public void checkOutItem() {
      // Implementation for checking out a book
  }

  @Override
  public void returnItem() {
      // Implementation for returning a book
  }


  private Library library;
  private String title;
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

  /**
   * Get the id of the book.
   *
   * @return The id of the book.
   */
  public String getId() {
    return this.isbn;
  }

  /**
   * Get the library that the book is in.
   *
   * @param library The library that the book is in.
   * @throws WrongLibraryException If the book is not in the library.
   */
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasBook(this)) {
      throw new WrongLibraryException(
          "Book " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /** Get the title of the book. */
  public String getTitle() {
    return title;
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

  /**
   * Check if the book is checked out.
   *
   * @return True if the book is checked out, false otherwise.
   * @throws LibraryNotSetException If the library is not set for the book.
   */
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for book " + this.getId());
    }
    return library.isCheckedOut(this);
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
