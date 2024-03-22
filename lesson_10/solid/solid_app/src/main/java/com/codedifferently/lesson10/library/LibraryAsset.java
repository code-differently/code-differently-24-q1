package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.Objects;

public abstract class LibraryAsset {

  protected Library library;
  protected String title;
  protected String isbn;
  protected boolean canCheckOut = true;

  LibraryAsset() {}

  /**
   * Get the library that the book is in.
   *
   * @param library The library that the item is in.
   * @throws WrongLibraryException If the book is not in the library.
   */
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasAsset(this)) {
      throw new WrongLibraryException(
          "Item " + this.getIsbn() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /** Get the title of the book. */
  public String getTitle() {
    return title;
  }

  /** Get the ISBN of the book. */
  public String getIsbn() {
    return isbn;
  }

  public Boolean getCanCheckOut() {
    return this.canCheckOut;
  }

  /**
   * Check if the book is checked out.
   *
   * @return True if the book is checked out, false otherwise.
   * @throws LibraryNotSetException If the library is not set for the book.
   */
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for item " + this.getIsbn());
    }
    return library.isCheckedOut(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LibraryAsset)) return false;
    LibraryAsset asset = (LibraryAsset) o;
    return Objects.equals(getIsbn(), asset.getIsbn());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getIsbn());
  }

  @Override
  public String toString() {
    return "Item{" + "id='" + getIsbn() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
