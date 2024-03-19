package com.codedifferently.lesson9.randycastro;

public class library {}

class Book {

  private String title;
  private String isbn;
  private String author;
  private int page;
  private boolean isCheckedOut;

  {

    // constructor
    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.page = page;
    this.isCheckedOut = false;
  }

  class Patron {

    private String name;
    private String booksCheckedOut;

    {

      // constructor
      this.name = name;
      this.booksCheckedOut = booksCheckedOut;
    }
  }
}
