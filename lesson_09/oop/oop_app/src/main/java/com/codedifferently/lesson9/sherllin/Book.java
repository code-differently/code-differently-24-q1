package com.codedifferently.lesson9.sherllin;

// We want to define a book and keep track of its title, isbn, author(s), number of pages, and
// whether it is checked out or not.
// We want define a patron with properties including their name and the books they have checked out.
// We want to define a library that:
// Allows us to add/remove a book to and from its collection of books.
// Allows us to register new patrons
// Allows us to check out books to patrons.
// Allows us to return books from patrons.

public class Book {
  private String bookTitle;
  private long isbn;
  private String author;
  private int pages;
  private boolean checkedOut;

  public Book(String bookTitle, long isbn, String author, int pages, boolean checkedOut) {
    this.bookTitle = bookTitle;
    this.isbn = isbn;
    this.author = author;
    this.pages = pages;
    this.checkedOut = checkedOut;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public long getIsbn() {
    return isbn;
  }

  public String getAuthor() {
    return author;
  }

  public int getPages() {
    return pages;
  }

  public boolean checkedOut() {
    return checkedOut;
  }
}
