package com.codedifferently.lesson9.natayaprice;

public class Book {

  private String Titles;
  private int ISBN;
  private String Authors;
  private int TotalPages;
  private boolean CheckedOut;

  /**
   * Constructs a new Book object.
   *
   * @param Titles the title of the book
   * @param ISBN the ISBN number of the book
   * @param Authors the author(s) of the book
   * @param TotalPages the total number of pages in the book
   * @param CheckedOut indicates whether the book is currently checked out
   */
  public Book(String Titles, int ISBN, String Authors, int TotalPages, boolean CheckedOut) {
    this.Titles = Titles;
    this.ISBN = ISBN;
    this.Authors = Authors;
    this.TotalPages = TotalPages;
    this.CheckedOut = CheckedOut;
  }

  /**
   * Gets the title of the book.
   *
   * @return the title of the book
   */
  public String getTitles() {
    return Titles;
  }

  /**
   * Gets the ISBN number of the book.
   *
   * @return the ISBN number of the book
   */
  public int getISBN() {
    return ISBN;
  }

  /**
   * Gets the author(s) of the book.
   *
   * @return the author(s) of the book
   */
  public String getAuthors() {
    return Authors;
  }

  /**
   * Gets the total number of pages in the book.
   *
   * @return the total number of pages in the book
   */
  public int getTotalPages() {
    return TotalPages;
  }

  /**
   * Checks if the book is currently checked out.
   *
   * @return true if the book is checked out, otherwise false
   */
  public boolean getCheckedOut() {
    return CheckedOut;
  }
}
