package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.BookCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.ArrayList;
import java.util.List;

/** Represents a patron of the library. */
public class Patron {
  private String name;
  private final String email;
  private List<MediaItem> checkedOutItems;
  private List<Library> libraries;

  /**
   * Creates a new patron.
   *
   * @param name the name of the patron
   * @param email the email of the patron
   */
  public Patron(String name, String email) {
    this.name = name;
    this.email = email;
    this.checkedOutItems = new ArrayList<>();
    this.libraries = new ArrayList<>();
  }

  /**
   * Gets the name of the patron.
   *
   * @return the name of the patron
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the patron.
   *
   * @param name the name of the patron
   */
  public String getEmail() {
    return email;
  }

  /** checks out a media item. */
  public void checkOut(MediaItem item) throws BookCheckedOutException {
    if (checkedOutItems.contains(item)) {
      throw new BookCheckedOutException("This item is already checked out by this patron.");
    } else {
      checkedOutItems.add(item);
      item.checkOut();
    }
  }

  /** checks in a media item. */
  public void checkIn(MediaItem item) {
    checkedOutItems.remove(item);
    item.checkIn();
  }

  /**
   * Gets the checked out items of the patron.
   *
   * @return the checked out items of the patron
   */
  public List<MediaItem> getCheckedOutItems() {
    return checkedOutItems;
  }

  /**
   * Adds a library to the patron.
   *
   * @param library the library to add
   */
  public void addLibrary(Library library) {
    libraries.add(library);
  }

  /**
   * Removes a library from the patron.
   *
   * @param library the library to remove
   */
  public void removeLibrary(Library library) {
    libraries.remove(library);
  }

  /**
   * Sets the library of the patron.
   *
   * @param library the library to set
   */
  public void setLibrary(Library library) throws WrongLibraryException {
    if (libraries.contains(library)) {
      library.addPatron(this);
    } else {
      throw new WrongLibraryException("This patron is not registered with this library.");
    }
  }

  /**
   * Gets the libraries of the patron.
   *
   * @return the libraries of the patron
   */
  public List<Library> getLibraries() {
    return libraries;
  }
}
