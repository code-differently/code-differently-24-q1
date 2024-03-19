package com.codedifferently.lesson9.randycastro;

public class library {

  class Book {

    private String title;
    private String isbn;
    private String author;
    private int page;
    private boolean checkedOut;

    // constructor for Book
    public Book(String title, String isbn, String author, int page, boolean checkedOut) {
      this.title = title;
      this.isbn = isbn;
      this.author = author;
      this.page = page;
      this.checkedOut = checkedOut;
    }

    // Getters and Setters

    public String getTitle() {
      return title;
    }

    public String getIsbn() {
      return isbn;
    }

    public String getAuthor() {
      return author;
    }

    public int getPage() {
      return page;
    }

    public boolean getCheckedout() {
      return checkedOut;
    }
  }

  class Patron {

    private String name;
    private String booksCheckedOut;

    // constructor
    public Patron(String name, String booksCheckedOut) {
      this.name = name;
      this.booksCheckedOut = booksCheckedOut;
    }
  }
}
