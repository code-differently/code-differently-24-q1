package main.java.com.codedifferently.lesson9.richhawkins;

import java.util.ArrayList;
import java.util.List;

public class Book {
  private String title;
  private int isbn;
  private List<String> authors = new ArrayList<>();
  private int numberOfPages;
  private boolean checkedOut;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getIsbn() {
    return isbn;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  public List<String> getAuthors() {
    return authors;
  }

  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }

  public int getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(int numberOfPages) {
    this.numberOfPages = numberOfPages;
  }

  public boolean getCheckedOut() {
    return checkedOut;
  }

  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  public Book(String title, int isbn, List<String> authors, int numberOfPages, boolean checkedOut) {
    this.title = title;
    this.isbn = isbn;
    this.authors = authors;
    this.numberOfPages = numberOfPages;
    this.checkedOut = checkedOut;
  }
}
