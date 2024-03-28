package com.codedifferently.lesson10.jadaslibrary;

import com.codedifferently.lesson10.jadaslibrary.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.jadaslibrary.exceptions.WrongLibraryException;
import java.util.List;
import java.util.Objects;

public class Patron {
  private Jadaslibrary library;
  private String name;
  private String email;

  public Patron(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public void setLibrary(Jadaslibrary library) {
    this.library = library;
  }

  public Jadaslibrary getLibrary() {
    return library;
  }

  public void returnMediaItem(MediaItem mediaItem) throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for patron " + this.getId());
    }
    this.library.returnMediaItem(mediaItem);
  }

  public String getName() {
    return this.name;
  }

  public String getId() {
    return email;
  }

  public List<Book> getCheckedOutBooks() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for patron " + this.getId());
    }
    return this.library.getCheckedOutBooksByPatron(this);
  }

  public void returnDvd(Dvd dvd) throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException(("Library not set for patron " + this.getId()));
    }
    if (!dvd.isCheckedOut() || !dvd.getPatron().equals(this)) {
      throw new WrongLibraryException(
          "DVD " + dvd.getId() + " was not checked out by patron " + this.getId());
    }
    dvd.setCheckedOut(false);
    dvd.setPatron(null);
  }

  public List<MediaItem> getCheckedOutMediaItems() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for patron " + this.getId());
    }
    return this.library.getCheckedOutMediaItemsByPatron(this);
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
