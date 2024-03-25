package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.UUID;

public abstract class MediaItem {
  public Library library;
  public String title;
  public UUID id;

  public MediaItem() {
    this.id = UUID.randomUUID();
  }

  abstract boolean canCheckOut();

  public UUID getId() {
    return this.id;
  }

  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasMediaItem(this)) {
      throw new WrongLibraryException(
          "Item " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  /** Get the title of the book. */
  public String getTitle() {
    return title;
  }

  /**
   * Check if the item is checked out.
   *
   * @return True if the item is checked out, false otherwise.
   * @throws LibraryNotSetException If the library is not set for the item.
   */
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for item " + this.getId());
    }
    return library.isCheckedOut(this);
  }
}
