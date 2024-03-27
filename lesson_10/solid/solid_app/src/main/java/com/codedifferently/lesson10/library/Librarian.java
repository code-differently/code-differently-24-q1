package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.media.Dvd;
import java.util.HashSet;
import java.util.Set;

/** Represents a librarian of a library. */
public class Librarian extends Patron {
  private Set<Dvd> dvds = new HashSet<>(); // Added for DVDs
  private Set<Dvd> checkedOutDvds = new HashSet<>(); // Added for checked out DVDs

  /**
   * Create a new librarian with the given id.
   *
   * @param id The id of the librarian.
   */
  public Librarian(String id) {
    super(id, "Librarian"); // Updated constructor call with role
  }

  /**
   * Add a DVD to the librarian's collection.
   *
   * @param dvd The DVD to add.
   */
  public void addDvd(Dvd dvd) {
    this.dvds.add(dvd);
  }

  /**
   * Remove a DVD from the librarian's collection.
   *
   * @param dvd The DVD to remove.
   */
  public void removeDvd(Dvd dvd) {
    this.dvds.remove(dvd);
  }

  /**
   * Check out a DVD to a patron.
   *
   * @param dvd The DVD to check out.
   * @param patron The patron to check out the DVD to.
   * @return True if the DVD was checked out, false otherwise.
   */
  public boolean checkOutDvd(Dvd dvd, Patron patron) {
    if (!canCheckOutDvd(dvd, patron)) {
      return false;
    }
    this.checkedOutDvds.add(dvd);
    return true;
  }

  private boolean canCheckOutDvd(Dvd dvd, Patron patron) {
    if (!this.hasDvd(dvd)) {
      return false;
    }
    if (!this.hasPatron(patron)) {
      return false;
    }
    return true;
  }

  /**
   * Check in a DVD from a patron.
   *
   * @param dvd The DVD to check in.
   * @param patron The patron returning the DVD.
   * @return True if the DVD was returned, false otherwise.
   */
  public boolean checkInDvd(Dvd dvd, Patron patron) {
    if (!this.checkedOutDvds.contains(dvd)) {
      return false;
    }
    this.checkedOutDvds.remove(dvd);
    return true;
  }

  /**
   * Check if the librarian has the given DVD.
   *
   * @param dvd The DVD to check for.
   * @return True if the librarian has the DVD, false otherwise.
   */
  public boolean hasDvd(Dvd dvd) {
    return this.dvds.contains(dvd);
  }

  /**
   * Check if the librarian has the given patron.
   *
   * @param patron The patron to check for.
   * @return True if the librarian has the patron, false otherwise.
   */
  public boolean hasPatron(Patron patron) {
    return this.getId().equals(patron.getId());
  }
}
