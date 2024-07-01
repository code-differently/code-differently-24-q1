package com.codedifferently.lesson9.AaronSantiago;

import java.util.ArrayList;
import java.util.List;

class LibraryGuest {
  private String name;
  private List<Book> checkedOutBooks;

  public LibraryGuest(String name) {
    this.name = name;
    this.checkedOutBooks = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
  }

  public boolean returnBook(Book book) {
    return checkedOutBooks.remove(book);
  }

  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void displayGuestDetails() {
    System.out.println("Guest Name: " + name);
    System.out.println("Checked Out Books:");
    for (Book book : checkedOutBooks) {
      book.displayBookDetails();
    }
  }
}
