package com.codedifferently.lesson9.mohamedibrahim;

import java.util.ArrayList;

public class Library {
  private ArrayList<Book> shelves = new ArrayList<Book>();
  private ArrayList<Integer> currentPatronIds = new ArrayList<Integer>();
  private ArrayList<Patron> currentPatrons = new ArrayList<Patron>();
  private ArrayList<Integer> usedIsbns = new ArrayList<Integer>();

  public Library() {}

    /**
    * Creates a library object and alowing the input of a Array of books 
    * @param shelves
    */
    public Library(ArrayList<Book> shelves) {
    this.shelves = shelves;
  }

    /**
    * Retreives current patrons in the library
    * @return Arraylist<Patrons>
    */
    public ArrayList<Patron> getCurrentPatrons() {
    return currentPatrons;
  }

    /**
    * Retrieves the existin patron Ids
    * @return
    */
    public ArrayList<Integer> getCurrentPatronIds() {
    return currentPatronIds;
  }
  /**
   * Retrieves the current books in the library
   * @return
   */
  public ArrayList<Book> getBooks() {
    return shelves;
  }

  /**
   * takes a book and adds it to the shelves array list and the used isbns array list
   * @param book
   */
  public void addBooks(Book book) {
    usedIsbns.add(book.getIsbn());
    shelves.add(book);
  }

  /**
   * same as add books but changes the boolen is checked out for the book to false
   * @param book
   */
  public void checkInBook(Book book) {
    addBooks(book);
    book.isReturned();
  }

  /**
   * Takes in a patron and checkes if the user id is already registered.
   * If it is, the code will produce an error stating the id is in use.
   * @param patron
   */
  public void registerPatron(Patron patron) {
    if (currentPatronIds.contains(patron.getId())) {
      throw new UserAlreadyRegistered("This User ID is In Use!");
    }
    currentPatronIds.add(patron.getId());
    currentPatrons.add(patron);
  }

  /**
   * This is for checking a book out. It takes in the book you are checking out in.
   * After it checkes if the book is on the shelves it is checked out and tbe book is removed from the list. 
   * @param book
   * @return Book
   */
  public Book checkOutBook(Book book) {
    if (shelves.contains(book)) {
      book.isCheckedOut();
      shelves.remove(book);
      return book;
    } else {
      throw new BookNotFound("Error Book not Found!");
    }
  }

  /**
   * Same as the code above just uses an array to check out more books at once.
   * @param books
   * @return
   */
  public ArrayList<Book> checkOutBook(ArrayList<Book> books) {
    if (shelves.containsAll(books)) {
      for (Book b : books) {
        b.isCheckedOut();
      }
      shelves.removeAll(books);
      return books;
    } else {
      throw new BookNotFound("Error Book not Found!");
    }
  }
}
