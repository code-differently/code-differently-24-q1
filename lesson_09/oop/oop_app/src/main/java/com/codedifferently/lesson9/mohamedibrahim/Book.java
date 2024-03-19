package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Book {
  private String name;
  private int isbn;
  private ArrayList<String> author = new ArrayList<String>();
  private int pageNums;
  private boolean checkedOut;

  public Book(String name, int isbn, String author, int pageNums) {
    this.name = name;
    this.isbn = isbn;
    this.author.add(author);
    this.pageNums = pageNums;
    this.checkedOut = false;
  }

  public Book(String name, int isbn, ArrayList<String> author, int pageNums) {
    this.name = name;
    this.isbn = isbn;
    this.author = author;
    this.pageNums = pageNums;
    this.checkedOut = false;
  }

  /**
   * @return ArrayList<String>
   */
  public ArrayList<String> getAuthor() {
    return author;
  }

  /**
   * @return int
   */
  public int getIsbn() {
    return isbn;
  }

  /**
   * @return String
   */
  public String getName() {
    return name;
  }

  /**
   * @return int
   */
  public int getPageNums() {
    return pageNums;
  }

  public boolean getStatus() {
    return checkedOut;
  }

  /**
   * @param author
   */
  public void setAuthor(ArrayList<String> author) {
    this.author = author;
  }

  public void isCheckedOut() {
    this.checkedOut = true;
  }

  public void isReturned() {
    this.checkedOut = true;
  }

  public void setIsbn(int isbn) {
    this.isbn = isbn;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPageNums(int pageNums) {
    this.pageNums = pageNums;
  }
}
