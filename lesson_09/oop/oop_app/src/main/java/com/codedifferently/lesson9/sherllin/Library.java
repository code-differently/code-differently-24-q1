package com.codedifferently.lesson9.sherllin;

import java.util.HashMap;
import java.util.Map;

// We want to define a library that:
// Allows us to add/remove a book to and from its collection of books.
// Allows us to register new patrons
// Allows us to check out books to patrons.

public class Library {
  private Map<Long, Boolean> bookStatus; // Used ISBN as the key for book status
  private Map<String, Integer> patronBooks; // Used name as key for patron's checked-out books count

  public Library() {
    this.bookStatus = new HashMap<>();
    this.patronBooks = new HashMap<>();
  }

  public void addBook(long isbn) {
    bookStatus.put(isbn, false); // Book is not checked out
  }

  public void removeBook(long isbn) {
    bookStatus.remove(isbn);
  }

  public void registerPatron(String patronName) {
    patronBooks.put(patronName, 0); // Patron has no books checked out
  }

  public void checkoutOrReturnBook(long isbn, String patronName, boolean checkOut) {
    Boolean isBookCheckedOut = bookStatus.get(isbn);
    Integer checkedOutBooksCount = patronBooks.getOrDefault(patronName, 0);

    if (isBookCheckedOut == null || checkedOutBooksCount == null) {
      System.out.println("Book or patron not found");
      return;
    }

    if (checkOut) {
      if (!isBookCheckedOut) {
        bookStatus.put(isbn, true);
        patronBooks.put(patronName, checkedOutBooksCount + 1);
        System.out.println("Book checked out to " + patronName);
      } else {
        System.out.println("Sorry! Book already checked out");
      }
    } else {
      if (isBookCheckedOut && checkedOutBooksCount > 0) {
        bookStatus.put(isbn, false);
        patronBooks.put(patronName, checkedOutBooksCount - 1);
        System.out.println("Book returned by " + patronName);
      } else {
        System.out.println("Book not checked out or invalid return operation");
      }
    }
  }

  public Map<Long, Boolean> getBookStatus() {
    return bookStatus;
  }

  public Map<String, Integer> getPatronBooks() {
    return patronBooks;
  }
}
