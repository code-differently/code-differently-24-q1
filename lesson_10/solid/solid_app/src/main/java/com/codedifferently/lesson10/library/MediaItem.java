package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;
import java.util.UUID;

/** Represents a media item in the library. */
abstract class MediaItem {
  public Library library;
  private UUID uuid;
  private String title;
  private String type;
  private boolean isCheckedOut;

  /** Creates a new MediaItem */
  public MediaItem(UUID uuid, String title, String type) {
    this.uuid = uuid;
    this.title = title;
    this.type = type;
    this.isCheckedOut = false;
  }

  /**
   * Gets the UUID of the media item.
   *
   * @return the UUID of the media item
   */
  public UUID getUUID() {
    return uuid;
  }

  /** Gets the title of the media item. */
  public String getTitle() {
    return title;
  }

  /**
   * Gets the type of the media item.
   *
   * @return the type of the media item
   */
  public String getType() {
    return type;
  }

  /**
   * Sets the title of the media item.
   *
   * @param title the title of the media item
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets the type of the media item.
   *
   * @param type the type of the media item
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Checks if the media item is checked out.
   *
   * @return true if the media item is checked out, false otherwise
   */
  public boolean isCheckedOut() {
    return isCheckedOut;
  }

  /**
   * Gets the library of the media item.
   *
   * @return the library of the media item
   */
  public Library getLibrary() {
    return library;
  }

  /**
   * Sets the library of the media item.
   *
   * @param library the library of the media item
   */
  public void setLibrary(Library library) {
    this.library = library;
  }

  /**
   * Checks out the media item.
   *
   * @throws MediaItemCheckedOutException if the media item is already checked out
   */
  public void checkOut() throws MediaItemCheckedOutException {
    if (isCheckedOut) {
      throw new MediaItemCheckedOutException("This item is already checked out.");
    }
    isCheckedOut = true;
  }

  /** Checks in the media item. */
  public void checkIn() {
    isCheckedOut = false;
  }

  @Override
  public String toString() {
    return "Title: " + title + ", Type: " + type + ", UUID: " + uuid;
  }

  /**
   * Checks if the media item can be checked out.
   *
   * @return true if the media item can be checked out, false otherwise
   */
  boolean canCheckOut() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
