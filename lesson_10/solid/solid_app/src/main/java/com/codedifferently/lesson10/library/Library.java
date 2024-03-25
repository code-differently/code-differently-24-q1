package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Represents a library. */
public class Library {
  private Map<String, LibraryAsset> itemByIds = new HashMap<>();
  private Set<String> checkedOutIsbns = new HashSet<>();
  private Map<String, Set<LibraryAsset>> checkedOutItemsByPatron = new HashMap<>();
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
   * @param librarian The librarian that added the item
   * @param asset The book to add.
   */
  public void addAsset(Librarian librarian, LibraryAsset asset) {
    this.itemByIds.put(asset.getIsbn(), asset);
    asset.setLibrary(this);
  }

  /**
   * Remove a item from the library.
   *
   * @param asset The item to remove.
   * @param librarian The librarian that removed the item.
   */
  public void removeAsset(Librarian librarian, LibraryAsset asset) throws BookCheckedOutException {
    if (this.isCheckedOut(asset)) {
      throw new BookCheckedOutException("Cannot remove checked out book.");
    }
    this.itemByIds.remove(asset.getIsbn());
    asset.setLibrary(null);
  }

  /**
   * Add a patron to the library.
   *
   * @param patron The patron to add.
   */
  public void addPatron(Patron patron) {
    this.patronIds.add(patron.getId());
    this.checkedOutItemsByPatron.put(patron.getId(), new HashSet<>());
    patron.setLibrary(this);
    patron.addLibrary(this);
  }

  /**
   * Remove a patron from the library.
   *
   * @param patron The patron to remove.
   */
  public void removePatron(Patron patron) throws BookCheckedOutException {
    if (!this.checkedOutItemsByPatron.get(patron.getId()).isEmpty()) {
      throw new BookCheckedOutException("Cannot remove patron with checked out books.");
    }
    this.patronIds.remove(patron.getId());
    this.checkedOutItemsByPatron.remove(patron.getId());
    patron.removeLibrary(this);
  }

  /**
   * Check out a item to a patron.
   *
   * @param asset The item to check out.
   * @param patron The patron to check out the book to.
   * @return True if the book was checked out, false otherwise.
   */
  public boolean checkOutItem(LibraryAsset asset, Patron patron) {
    if (!this.canCheckOutAsset(asset, patron)) {
      return false;
    }
    this.checkedOutIsbns.add(asset.getIsbn());
    this.checkedOutItemsByPatron.get(patron.getId()).add(asset);
    return true;
  }

  public LibraryAsset assetSearch(LibraryAsset asset) {
    return this.itemByIds.get(asset.getIsbn());
  }

  private boolean canCheckOutAsset(LibraryAsset asset, Patron patron) {
    if (!this.hasAsset(asset)) {
      return false;
    }
    if (this.isCheckedOut(asset)) {
      return false;
    }
    if (!this.hasPatron(patron)) {
      return false;
    }
    if (!asset.isAbleToCheckOut()) {
      return false;
    }
    return true;
  }

  /**
   * Check if the library has the given item.
   *
   * @param asset The item to check for.
   * @return True if the library has the item, false otherwise.
   */
  public boolean hasAsset(LibraryAsset asset) {
    return this.itemByIds.containsKey(asset.getIsbn());
  }

  /**
   * Check if the given item is checked out.
   *
   * @param asset The item to check.
   * @return True if the item is checked out, false otherwise.
   */
  public boolean isCheckedOut(LibraryAsset asset) {
    return this.checkedOutIsbns.contains(asset.getIsbn());
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

  /**
   * Return a item to the library.
   *
   * @param asset The item to return.
   * @param patron The patron returning the book.
   * @return True if the item was returned, false otherwise.
   */
  public boolean checkInItem(LibraryAsset asset, Patron patron) {
    if (!this.hasAsset(asset)) {
      return false;
    }
    this.checkedOutIsbns.remove(asset.getIsbn());
    this.checkedOutItemsByPatron.get(patron.getId()).remove(asset);
    return true;
  }

  /**
   * Get the books checked out by a patron.
   *
   * @param patron The patron to get the books for.
   * @return The books checked out by the patron.
   */
  public Set<LibraryAsset> getCheckedOutByPatron(Patron patron) {
    return this.checkedOutItemsByPatron.get(patron.getId());
  }

  @Override
  public String toString() {
    return "Library{"
        + "itemByIds="
        + itemByIds
        + ", checkedOutIsbns="
        + checkedOutIsbns
        + ", checkedOutItemsByPatron="
        + checkedOutItemsByPatron
        + ", patronIds="
        + patronIds
        + '}';
  }
}
