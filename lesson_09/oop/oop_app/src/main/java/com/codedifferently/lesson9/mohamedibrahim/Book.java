package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Book {
  private String name;
  private int isbn;
  private ArrayList<String> author = new ArrayList<String>();
  private int pageNums;
  private boolean checkedOut;

  /**
   * Takes in all of the elaments of the book class exept for the boolean checked out. This is due
   * to all the books made will be by defult checked in.
   *
   * @param name the title of each book
   * @param isbn a unique id for each book
   * @param author takes in the name of ONE author in the form of a string
   * @param pageNums the number of pages in each book
   */
  public Book(String name, int isbn, String author, int pageNums) {
    this.name = name;
    this.isbn = isbn;
    this.author.add(author);
    this.pageNums = pageNums;
    this.checkedOut = false;
  }

  /**
   * Same as above however takes in a list of names
   *
   * @param name the title of each book
   * @param isbn a unique id for each book
   * @param author takes in the name of MANY author in the form of a Arraylist =
   * @param pageNums the number of pages in each book
   */
  public Book(String name, int isbn, ArrayList<String> author, int pageNums) {
    this.name = name;
    this.isbn = isbn;
    this.author = author;
    this.pageNums = pageNums;
    this.checkedOut = false;
  }

  /**
   * Retruns the author arraylists
   *
   * @return ArrayList<String>
   */
  public ArrayList<String> getAuthor() {
    return author;
  }

  /**
   * returns the unique isbn number
   *
   * @return int
   */
  public int getIsbn() {
    return isbn;
  }

  /**
   * returns the book name
   *
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * returns the page number
   *
   * @return int
   */
  public int getPageNums() {
    return pageNums;
  }

  /**
   * Tells the user if the book is checked in or out
   *
   * @return
   */
  public boolean getStatus() {
    return checkedOut;
  }

  /**
   * adds authors to the author arrayList
   *
   * @param author
   */
  public void addAuthors(ArrayList<String> author) {
    this.author.addAll(author);
  }

  /**
   * adds AN author to the author arrayList
   *
   * @param author
   */
  public void addAuthor(String author) {
    this.author.add(author);
  }

  /**
   * Removes AN author from a book
   *
   * @param author
   */
  public void removeAuthor(String author) {
    if (this.author.contains(author)) {
      this.author.remove(author);
    }
  }

  /**
   * Removes AN author from a book
   *
   * @param author
   */
  public void removeAuthors(ArrayList<String> author) {
    if (this.author.containsAll(author)) {
      this.author.removeAll(author);
    }
  }

  /** Sets the boolean to checkedout */
  public void isCheckedOut() {
    this.checkedOut = true;
  }

  /** Sets the boolean to returned */
  public void isReturned() {
    this.checkedOut = true;
  }

  /**
   * takes in a new isbn and sets it as the isbn
   *
   * @param isbn
   */
  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  /**
   * takes in a new string name and makes it name of the object
   *
   * @param name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Takes in a new number that becomes the page number of that book
   *
   * @param pageNums
   */
  public void setPageNums(int pageNums) {
    this.pageNums = pageNums;
  }
}
