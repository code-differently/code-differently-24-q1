package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.Objects;
import java.util.Set;

/** Represents a patron of a library. */
public class Patron {
  protected Library library;
  protected String name;
  protected String email;

  /**
   * Create a new patron with the given name and email.
   *
   * @param name The name of the patron.
   * @param email The email of the patron.
   */
  public Patron(String name, String email, Library library) {
    this.name = name;
    this.email = email;
    this.library = library;
  }

  public Library getLibrary() {
    return this.library;
  }

  /**
   * Set the library that the patron is in.
   *
   * @param library The library that the patron is in.
   * @throws WrongLibraryException If the patron is not in the library.
   */
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasPatron(this)) {
      throw new WrongLibraryException(
          "Patron " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /** Get the name of the patron. */
  public String getName() {
    return this.name;
  }

  /** Set the name of the patron. */
  public void setName(String name) {
    this.name = name;
  }

  /** Get the email of the patron. */
  public String getId() {
    return this.email;
  }

  /**
   * Gets the books currently checked out to the patron.
   *
   * @return The books currently checked out to the patron.
   * @throws LibraryNotSetException If the library is not set for the patron.
   */
  public Set<MediaItem> getCheckedOutMedia() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for patron " + this.getId());
    }
    return this.library.getCheckedOutByPatron(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Patron)) return false;
    Patron patron = (Patron) o;
    return Objects.equals(getId(), patron.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "Patron{" + "id='" + getId() + '\'' + ", name='" + getName() + '\'' + '}';
  }
}
