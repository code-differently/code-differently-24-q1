package com.codedifferently.lesson9.mohamedibrahim;

import com.google.common.base.Objects;
import java.util.ArrayList;

public class Book {
  private String name;
  private int isbn;
  private ArrayList<String> authors = new ArrayList<String>();
  private int pageNums;
  private boolean checkedOut;
  private Library origin;

  /**
   * Takes in all of the elaments of the book class exept for the boolean checked out. This is due
   * to all the books made will be by defult checked in.
   *
   * @param name The title of each book.
   * @param isbn A unique id for each book.
   * @param author Takes in the name of ONE author in the form of a string.
   * @param pageNums The number of pages in each book.
   */
  public Book(String name, int isbn, String author, int pageNums, Library origin) {
    this.name = name;
    this.isbn = isbn;
    this.authors.add(author);
    this.pageNums = pageNums;
    this.checkedOut = false;
    this.origin = origin;
  }

  /**
   * Same as above however takes in a list of names.
   *
   * @param name The title of each book.
   * @param isbn A unique id for each book.
   * @param author Takes in the name of MANY author in the form of a Arraylist.
   * @param pageNums The number of pages in each book.
   */
  public Book(String name, int isbn, ArrayList<String> authors, int pageNums, Library origin) {
    this.name = name;
    this.isbn = isbn;
    this.authors = authors;
    this.pageNums = pageNums;
    this.checkedOut = false;
    this.origin = origin;
  }

  /**
   * Returns the author arraylists.
   *
   * @return ArrayList<String>
   */
  public ArrayList<String> getAuthor() {
    return authors;
  }

  /**
   * Returns the unique isbn number.
   *
   * @return int
   */
  public int getIsbn() {
    return isbn;
  }

  /**
   * Returns the book name.
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the page number.
   *
   * @return int
   */
  public int getPageNums() {
    return pageNums;
  }

  /**
   * Tells the user if the book is checked in or out.
   *
   * @return
   */
  public boolean getStatus() {
    return checkedOut;
  }

  public Library getOrigin() {
    return origin;
  }

  /**
   * Adds authors to the author arrayList.
   *
   * @param author
   */
  public void addAuthors(ArrayList<String> author) {
    this.authors.addAll(author);
  }

  /**
   * Adds AN author to the author arrayList.
   *
   * @param author
   */
  public void addAuthor(String author) {
    this.authors.add(author);
  }

  /**
   * Removes AN author from a book.
   *
   * @param author
   */
  public void removeAuthor(String author) {
    if (this.authors.contains(author)) {
      this.authors.remove(author);
    }
  }

  /**
   * Removes many author from a book.
   *
   * @param author
   */
  public void removeAuthors(ArrayList<String> author) {
    if (this.authors.containsAll(author)) {
      this.authors.removeAll(author);
    }
  }

  /** Sets the boolean to checkedout. */
  public void checkOut() {
    this.checkedOut = true;
  }

  /** Sets the boolean to false meaning the book is returned. */
  public void checkIn() {
    this.checkedOut = false;
  }

  /**
   * Takes in a new isbn and sets it as the isbn.
   *
   * @param isbn
   */
  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  /**
   * Takes in a new string name and makes it name of the object.
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Takes in a new number that becomes the page number of that book.
   *
   * @param pageNums
   */
  public void setPageNums(int pageNums) {
    this.pageNums = pageNums;
  }

  public void setOrigin(Library origin) {
    this.origin = origin;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    else if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equal(isbn, book.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(isbn);
  }
}
