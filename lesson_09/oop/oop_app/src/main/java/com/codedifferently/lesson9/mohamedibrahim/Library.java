package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
  private HashMap<Integer, Book> shelves = new HashMap<>();
  private HashMap<Integer, Patron> currentPatronsById = new HashMap<>();

  public Library() {}

  /**
   * Creates a library object and alowing the input of a Array of books
   *
   * @param shelves
   */
  public Library(ArrayList<Book> books) {

    for (Book i : books) {
      this.shelves.put(i.hashCode(), i);
    }
  }

  /**
   * Retreives current patrons and ids in the library.
   *
   * @return Arraylist<Patrons>
   */
  HashMap<Integer, Patron> getCurrentPatronsById() {
    return currentPatronsById;
  }

  /**
   * Retrieves the current books and isbn in the library.
   *
   * @return
   */
  HashMap<Integer, Book> getShelves() {
    return shelves;
  }

  /**
   * Retrieves the current books in the library.
   *
   * @return
   */

  /**
   * Takes a book and adds it to the shelves array list and the used isbns arraylist.
   *
   * @param book
   */
  public void addBook(Book book) {
    shelves.put(book.hashCode(), book);
  }

  /**
   * Same as add books but changes the boolen is checked out for the book to false.
   *
   * @param book
   */
  public void checkInBook(Book book, Library library) {
    if (!(book.getOrigin().equals(library))) {
      throw new BookOfDifferentOrginException("Book Not From This Library");
    }
    addBook(book);
    book.checkIn();
  }

  /**
   * Takes in a patron and checkes if the user id is already registered. If it is, the code will
   * produce an error stating the id is in use.
   *
   * @param patron
   */
  public void registerPatron(Patron patron) {
    if (currentPatronsById.containsKey(patron.getId())) {
      throw new UserAlreadyRegisteredException("This User ID is In Use!");
    }
    currentPatronsById.put(patron.getId(), patron);
  }

  /**
   * Removes a patron from the patronbyid hash map.
   *
   * @param patron
   */
  public void unRegisterPatron(Patron patron) {
    if (!currentPatronsById.containsKey(patron.getId())) {
      throw new UserNotRegisteredException("USER NOT REGISTERED!");
    }
    currentPatronsById.remove(patron.getId(), patron);
  }

  /**
   * This is for checking a book out. It takes in the book you are checking out in. After it
   * checkes, if the book is on the shelves it is checked out and tbe book is removed from the list.
   *
   * @param book
   * @return Book
   */
  public Book checkOutBook(Book book) {
    if (!(shelves.containsKey(book.hashCode()))) {
      throw new BookNotFoundException("Error Book not Found!");
    } else {
      book.checkOut();
      shelves.remove(book.hashCode());
      return book;
    }
  }

  /**
   * Same as the code above just uses an array to check out more books at once.
   *
   * @param books
   * @return ArrayList<Books>
   */
  public ArrayList<Book> checkOutBooks(ArrayList<Book> books) {

    int i = 0;
    for (Book b : books) {
      if (!(this.shelves.containsValue(b))) {
        i++;
      } else {
        b.checkOut();
        this.shelves.remove(b.getIsbn(), b);
      }
    }
    if (i + 1 == books.size()) {
      throw new BookNotFoundException("Error Book not found");
    }
    return books;
  }
}
