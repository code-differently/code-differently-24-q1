package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.List;
import java.util.Objects;

/** Represents a book. */
public class Book extends MediaItem {
  private String title;
  private String isbn;
  private List<String> authors;
  private int numberOfPages;
  private boolean checkedOut;

  /**
   * Create a new book with the given title, ISBN, authors, and number of pages.
   *
   * @param title The title of the book.
   * @param isbn The ISBN of the book.
   * @param authors The authors of the book.
   * @param numberOfPages The number of pages in the book.
   * @param checkedOut The checked out status of the book.
   */
  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.checkedOut = false;
  }

  /**
   * Get the id of the book.
   *
   * @return The id of the book.
   */
  public String getId() {
    return this.isbn;
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
   * @return True if the book is checked out, otherwise false.
   * @throws LibraryNotSetException If the library is not set for the book.
   */
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for book " + this.getId());
    }
    return library.isCheckedOut(this);
  }

  /**
   * Set the checked out status of the book.
   *
   * @param checkedOut The checked out status to set.
   */
  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  /**
   * Get the library that the book is in.
   *
   * @return The library that the book is in.
   */
  @Override
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasBook(this)) {
      throw new WrongLibraryException(
          "Book " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /**
   * Get the library that the book is in.
   *
   * @return The library that the book is in.
   */
  public Library getLibrary() {
    return this.library;
  }

  /**
   * Check if the book is equal to the given object.
   *
   * @param o The object to compare to.
   * @return True if the object is a book with the same ISBN, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;
    Book book = (Book) o;
    return Objects.equals(getIsbn(), book.getIsbn());
  }

  /**
   * Get the hash code of the book.
   *
   * @return The hash code of the book.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  /**
   * Get the string representation of the book.
   *
   * @return The string representation of the book.
   */
  @Override
  public String toString() {
    return "Book{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }

  /**
   * Search for a book by its title.
   *
   * @param title The title to search for.
   * @return True if the book's title matches, otherwise false.
   */
  public boolean searchByTitle(String title) {
    return this.title.equalsIgnoreCase(title);
  }

  /**
   * Search for a book by its ISBN.
   *
   * @param isbn The ISBN to search for.
   * @return True if the book's ISBN matches, otherwise false.
   */
  public boolean searchByIsbn(String isbn) {
    return this.isbn.equals(isbn);
  }

  /**
   * Search for a book by its author.
   *
   * @param author The author to search for.
   * @return True if the book's author matches, otherwise false.
   */
  public boolean searchByAuthor(String author) {
    return authors.stream().anyMatch(a -> a.equalsIgnoreCase(author));
  }
}
