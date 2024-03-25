package com.codedifferently.lesson10.library;

/** Represents a librarian of a library. */
public class Librarian extends Patron {

  /**
   * Create a new librarian with the given name and email.
   *
   * @param name The name of the librarian.
   * @param email The email of the librarian.
   */
  public Librarian(String name, String email) {
    super(name, email);
  }

  /**
   * Check in a book to the library.
   *
   * @param book The book to check in.
   * @return True if the book was checked in, false otherwise.
   */
  public boolean checkInBook(Book book) {
    if (book.isCheckedOut()) {
      // Remove the book from the set of checked out books and return it to the library
      boolean bookReturned = book.getLibrary().checkInBook(book, this);
      if (bookReturned) {
        System.out.println("Book checked in successfully by librarian.");
        return true;
      } else {
        System.out.println("Failed to check in the book.");
        return false;
      }
    } else {
      System.out.println("The book is not checked out.");
      return false;
    }
  }
}
