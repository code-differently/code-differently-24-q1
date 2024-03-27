package com.codedifferently.lesson10.jadaslibrary;

import com.codedifferently.lesson10.jadaslibrary.exceptions.WrongLibraryException;
import java.util.List;
import java.util.Objects;

public class Book extends MediaItem {
  private String isbn;
  private List<String> authors;
  private int numberOfPages;
  private Jadaslibrary library;
  private Patron patron;
  private String author;

  // Constructor
  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
    super(title, isbn, numberOfPages);
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.author = author;
  }

  // Set the library for the book
  public void setLibrary(Jadaslibrary library) {
    if (library != null && !library.hasBook(this)) {
      throw new WrongLibraryException("Book " + isbn + " is not in the provided library");
    }
    this.library = library;
  }

  // Getters and setters
  public String getIsbn() {
    return isbn;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public Jadaslibrary getLibrary() {
    return library;
  }

  public String getId() {
    return isbn;
  }

  public Patron getPatron() {
    return patron;
  }

  public void setPatron(Patron patron) {
    this.patron = patron;
  }

  // Overridden methods
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
