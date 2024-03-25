package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.DvdCheckedOutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Represents a library. */
public class Library {
  private Set<String> bookIds = new HashSet<>();
  private Set<String> dvdIssns = new HashSet<>();
  private Set<String> checkedOutIsbns = new HashSet<>();
  private Set<String> checkedOutDvdIssns = new HashSet<>();
  private Set<String> magazineIssns = new HashSet<>();
  private Set<String> newspaperIssns = new HashSet<>();
  private Map<String, Set<Book>> checkedOutBooksByPatron = new HashMap<>();
  private Set<Integer> librarianEmpIds = new HashSet<>();
  private Map<Integer, Set<Book>> checkedOutBooksByLibrarian = new HashMap<>();
  private final Map<String, Set<Dvd>> checkedOutDvdsByPatron = new HashMap<>();
  private Set<String> patronIds = new HashSet<>();
  private String id;

  /**
   * Create a new library with the given id.
   *
   * @param id The id of the library.
   */
  public Library(String id) {
    this.id = id;
  }

  /**
   * Get the id of the library.
   *
   * @return The id of the library.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Add a book to the library.
   *
   * @param book The book to add.
   */
  public void addBook(Book book) {
    this.bookIds.add(book.getId());
    book.setLibrary(this);
  }

  public void removeBook(Book book) throws BookCheckedOutException {
    if (this.isCheckedOut(book)) {
      throw new BookCheckedOutException("Cannot remove checked out book.");
    }
    this.bookIds.remove(book.getId());
    book.setLibrary(null);
  }

  public void addDvd(Dvd dvd) {
    this.dvdIssns.add(Integer.toString(dvd.getIssn()));
    dvd.setLibrary(this);
  }

  public void removeDvd(Dvd dvd) throws DvdCheckedOutException {
    if (isCheckedOut(dvd)) {
      throw new DvdCheckedOutException("Cannot remove checked out DVD.");
    }
    dvdIssns.remove(Integer.toString(dvd.getIssn()));
    dvd.setLibrary(null);
  }

  public void addMagazine(Magazine magazine) {
    this.magazineIssns.add(Integer.toString(magazine.getIssn()));
    magazine.setLibrary(this);
  }

  public void addNewspaper(Newspaper newspaper) {
    this.newspaperIssns.add(Integer.toString(newspaper.getIssn()));
    newspaper.setLibrary(this);
  }

  public void removeNewspaper(Newspaper newspaper) {
    this.newspaperIssns.remove(Integer.toString(newspaper.getIssn()));
    newspaper.setLibrary(null);
  }

  public void removeMagazine(Magazine magazine) {
    this.magazineIssns.remove(Integer.toString(magazine.getIssn()));
    magazine.setLibrary(null);
  }

  /**
   * Add a patron to the library.
   *
   * @param patron The patron to add.
   */
  public void addPatron(Patron patron) {
    this.patronIds.add(patron.getId());
    this.checkedOutBooksByPatron.put(patron.getId(), new HashSet<>());
    patron.setLibrary(this);
  }

  public void addLibrarian(Librarian librarian) {
    this.librarianEmpIds.add(librarian.getEmpId());
    this.checkedOutBooksByLibrarian.put(librarian.getEmpId(), new HashSet<>());
    librarian.setLibrary(this);
  }

  /**
   * Remove a patron from the library.
   *
   * @param patron The patron to remove.
   */
  public void removePatron(Patron patron) throws BookCheckedOutException {
    Set<Book> patronCheckedOutBooks = this.checkedOutBooksByPatron.get(patron.getId());
    if (patronCheckedOutBooks != null && !patronCheckedOutBooks.isEmpty()) {
      throw new BookCheckedOutException("Cannot remove patron with checked out items.");
    }
    this.patronIds.remove(patron.getId());
    this.checkedOutBooksByPatron.remove(patron.getId());
    patron.setLibrary(null);
  }

  public void removeLibrarian(Librarian librarian) throws BookCheckedOutException {
    Set<Book> librarianCheckedOutBooks = this.checkedOutBooksByLibrarian.get(librarian.getEmpId());
    if (librarianCheckedOutBooks != null && !librarianCheckedOutBooks.isEmpty()) {
      throw new BookCheckedOutException("Cannot remove librarian with checked out items.");
    }
    this.librarianEmpIds.remove(librarian.getEmpId());
    this.checkedOutBooksByLibrarian.remove(librarian.getEmpId());
    librarian.setLibrary(null);
  }

  /**
   * Check out a book to a patron.
   *
   * @param book The book to check out.
   * @param patron
   * @param librarian The patron to check out the book to.
   * @return True if the book was checked out, false otherwise.
   */
  public boolean checkOutBook(Book book, Patron patron, Librarian librarian) {
    if (!this.canCheckOutBook(book, patron, librarian)) {
      return false;
    }
    this.checkedOutIsbns.add(book.getIsbn());
    this.checkedOutBooksByPatron.get(patron.getId()).add(book);
    return true;
  }

  private boolean canCheckOutBook(Book book, Patron patron, Librarian librarian) {
    if (!this.hasBook(book)) {
        return false;
    }
    if (this.isCheckedOut(book)) { 
        return false;
    }
    if (!this.hasPatron(patron)) {
        return false;
    }
    if (librarian == null) {
        return false;
    }
    return true;
}

  public boolean checkOutBook(Book book, Librarian librarian) {
    if (!this.canCheckOutBook(book, librarian)) {
      return false;
    }
    this.checkedOutIsbns.add(book.getIsbn());
    this.checkedOutBooksByLibrarian.get(librarian.getEmpId()).add(book);
    return true;
  }

  private boolean canCheckOutBook(Book book, Librarian librarian) {
    if (!this.hasBook(book)) {
      return false;
    }
    if (this.isCheckedOut(book)) {
      return false;
    }
    if (!this.hasLibrarian(librarian)) {
      return false;
    }
    return true;
  }

  public Set<Book> getCheckedOutByLibrarian(Librarian librarian) {
    return this.checkedOutBooksByLibrarian.get(librarian.getEmpId());
  }

  // check out dvd

  public boolean checkOutDvd(Dvd dvd, Patron patron) {
    if (!hasDvd(dvd)) {
        return false; 
    }
    if (isCheckedOut(dvd)) {
        return false; 
    }
    Set<Dvd> patronDvds = this.checkedOutDvdsByPatron.computeIfAbsent(patron.getId(), k -> new HashSet<>());
    patronDvds.add(dvd);
    checkedOutDvdIssns.add(Integer.toString(dvd.getIssn()));
    return true;
}




  /**
   * Check if the library has the given book.
   *
   * @param book The book to check for.
   * @return True if the library has the book, false otherwise.
   */
  public boolean hasBook(Book book) {
    return this.bookIds.contains(book.getId());
  }

  public boolean hasDvd(Dvd dvd) {
    String dvdIssnString = Integer.toString(dvd.getIssn());
    return this.dvdIssns.contains(dvdIssnString);
  }

  public boolean hasNewspaper(Newspaper newspaper) {
    String newspaperIssnString = Integer.toString(newspaper.getIssn());
    return this.newspaperIssns.contains(newspaperIssnString);
  }

  public boolean hasMagazine(Magazine magazine) {
    String magazineIssnString = Integer.toString(magazine.getIssn());
    return this.magazineIssns.contains(magazineIssnString);
  }

  public boolean isCheckedOut(Book book) {
    return this.checkedOutIsbns.contains(book.getIsbn());
  }

  public boolean isCheckedOut(Dvd dvd) {
    return checkedOutDvdIssns.contains(Integer.toString(dvd.getIssn()));
  }

  /**
   * Check if the library has the given patron.
   *
   * @param patron The patron to check for.
   * @return True if the library has the patron, false otherwise.
   */
  public boolean hasPatron(Patron patron) {
    return this.patronIds.contains(patron.getId());
  }

  public boolean hasLibrarian(Librarian librarian) {
    return this.librarianEmpIds.contains(librarian.getEmpId());
  }

  /**
   * Return a book to the library.
   *
   * @param book The book to return.
   * @param patron The patron returning the book.
   * @return True if the book was returned, false otherwise.
   */
  public boolean checkInBook(Book book, Patron patron) {
    if (!this.hasBook(book)) {
      return false;
    }
    this.checkedOutIsbns.remove(book.getIsbn());
    this.checkedOutBooksByPatron.get(patron.getId()).remove(book);
    return true;
  }

  public boolean checkInDvd(Dvd dvd, Patron patron) {
    if (!this.hasDvd(dvd)) {
      return false;
    }
    this.checkedOutDvdIssns.remove(Integer.toString(dvd.getIssn()));
    this.checkedOutDvdsByPatron.get(patron.getId()).remove(dvd);
    return true;
  }

  /**
   * Get the books checked out by a patron.
   *
   * @param patron The patron to get the books for.
   * @return The books checked out by the patron.
   */
  public Set<Book> getCheckedOutByPatron(Patron patron) {
    return this.checkedOutBooksByPatron.get(patron.getId());
  }

  /**
   * Get the DVDs checked out by a patron.
   *
   * @param patron The patron to get the DVDs for.
   * @return The DVDs checked out by the patron.
   */
  public Set<Dvd> getCheckedOutDvdsByPatron(Patron patron) {
    return this.checkedOutDvdsByPatron.get(patron.getId());
  }

  @Override
  public String toString() {
    return "Library{"
        + "bookIds="
        + bookIds
        + ", dvdIssns="
        + dvdIssns
        + ", checkedOutIsbns="
        + checkedOutIsbns
        + ", checkedOutBooksByPatron="
        + checkedOutBooksByPatron
        + ", checkedOutDvdsByPatron="
        + checkedOutDvdsByPatron
        + ", patronIds="
        + patronIds
        + ", librarianIds="
        + librarianempIds
        + '}';
  }
}
