package com.codedifferently.lesson10.library;

/** Represents a librarian in a library. */
public class Librarian extends Patron {

  /**
   * Create a new librarian with the given name and email.
   *
   * @param name The name of the librarian.
   * @param email The email of the librarian.
   */
  public Librarian(String name, String email) {
    super(name, email);
  }

  /**
   * Check out a media item from the library.
   *
   * @param item The media item to check out.
   * @param library The library to check out the media item from.
   * @return True if the media item was checked out, false otherwise.
   */
  public boolean checkOutMedia(MediaItem item, Library library) {
    return library.CheckOutMedia((Book) item, this);
  }

  /**
   * Check in a media item to the library.
   *
   * @param item The media item to check in.
   * @param library The library to check in the media item to.
   * @return True if the media item was checked in, false otherwise.
   */
  public boolean checkInMedia(MediaItem item, Library library) {
    return library.CheckInMedia((Book) item, this);
  }
}
