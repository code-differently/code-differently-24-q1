package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.Objects;

public class Dvd {
  private Library library;
  private String title;
  private int issn;

  /**
   * Create a new DVD with the given title and ISSN.
   *
   * @param title The title of the DVD.
   * @param issn The ISSN of the DVD.
   */
  public Dvd(String title, int issn) {
    this.title = title;
    this.issn = issn;
  }

  /**
   * Get the ISSN of the DVD.
   *
   * @return The ISSN of the DVD.
   */
  public int getIssn() {
    return this.issn;
  }

  /**
   * Get the library that the DVD is in.
   *
   * @return The library that the DVD is in.
   */
  public Library getLibrary() {
    return library;
  }

  /**
   * Set the library that the DVD is in.
   *
   * @param library The library that the DVD is in.
   * @throws WrongLibraryException If the DVD is not in the library.
   */
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasDvd(this)) {
      throw new WrongLibraryException(
          "Dvd " + this.getIssn() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /**
   * Get the title of the DVD.
   *
   * @return The title of the DVD.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Check if the DVD is checked out.
   *
   * @return True if the DVD is checked out, false otherwise.
   * @throws LibraryNotSetException If the library is not set for the DVD.
   */
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for DVD " + this.getIssn());
    }
    return library.isCheckedOut(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Dvd)) return false;
    Dvd dvd = (Dvd) o;
    return getIssn() == dvd.getIssn();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIssn());
  }

  @Override
  public String toString() {
    return "Dvd{" + "issn='" + getIssn() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
