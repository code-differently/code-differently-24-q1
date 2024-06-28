package com.codedifferently.lesson9.AaronSantiago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryBuildingLog {
  private Map<String, Book> books;
  private List<LibraryGuest> guests;

  public LibraryBuildingLog() {
    this.books = new HashMap<>();
    this.guests = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.put(book.getISBN(), book);
  }

  public boolean removeBook(String ISBN) {
    return books.remove(ISBN) != null;
  }

  public void registerGuest(LibraryGuest guest) {
    guests.add(guest);
  }

  public boolean checkOutBook(String ISBN, LibraryGuest guest) {
    Book book = books.get(ISBN);
    if (book != null && !isBookCheckedOut(book)) {
      guest.checkOutBook(book);
      return true;
    }
    return false;
  }

  public boolean returnBook(String ISBN, LibraryGuest guest) {
    Book book = books.get(ISBN);
    if (book != null) {
      return guest.returnBook(book);
    }
    return false;
  }

  private boolean isBookCheckedOut(Book book) {
    for (LibraryGuest guest : guests) {
      if (guest.getCheckedOutBooks().contains(book)) {
        return true;
      }
    }
    return false;
  }

  public void displayLibraryInformation() {
    System.out.println("Library Books:");
    books.values().forEach(Book::displayBookDetails);
    System.out.println("\nLibrary Guests:");
    guests.forEach(
        guest -> {
          System.out.println("Name: " + guest.getName());
          if (!guest.getCheckedOutBooks().isEmpty()) {
            guest.displayGuestDetails();
          } else {
            System.out.println("No books checked out.");
          }
        });
  }
}
