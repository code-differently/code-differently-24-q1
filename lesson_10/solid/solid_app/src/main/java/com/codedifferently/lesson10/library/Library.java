package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a library. */
public class Library {
  private Set<UUID> mediaIds = new HashSet<>();
  private Set<UUID> checkedOutId = new HashSet<>();
  private Map<UUID, MediaItem> mediaItemsMap = new HashMap<>();
  private Map<Patron, Set<MediaItem>> checkedOutMediaByPatron = new HashMap<>();
  private Set<Patron> patrons = new HashSet<>();
  private Librarian librarian;

  /**
   * Sets the librarian of the library.
   *
   * @param librarian the librarian of the library
   */
  public void setLibrarian(Librarian librarian) {
    this.librarian = librarian;
  }

  /**
   * Gets the librarian of the library.
   *
   * @return the librarian of the library
   */
  public Librarian getLibrarian() {
    return this.librarian;
  }

  /**
   * Adds a media item to the library.
   *
   * @param item the media item to add
   */
  public void addMediaItem(MediaItem item) {
    if (librarian == null) {
      throw new RuntimeException("Librarian not present.");
    }
    mediaIds.add(item.getUUID());
    mediaItemsMap.put(item.getUUID(), item);
  }

  /**
   * Removes a media item from the library.
   *
   * @param item the media item to remove
   */
  public void removeMediaItem(MediaItem item) {
    if (librarian == null) {
      throw new RuntimeException("Librarian not present.");
    }
    mediaIds.remove(item.getUUID());
    mediaItemsMap.remove(item.getUUID());
  }

  /**
   * Adds a patron to the library.
   *
   * @param patron the patron to add
   */
  public void addPatron(Patron patron) {
    if (librarian == null) {
      throw new RuntimeException("Librarian not present.");
    }
    patrons.add(patron);
    checkedOutMediaByPatron.put(patron, new HashSet<>());
  }

  /**
   * Removes a patron from the library.
   *
   * @param patron the patron to remove
   * @throws MediaItemCheckedOutException if the patron has checked out media
   */
  public void removePatron(Patron patron) throws MediaItemCheckedOutException {
    if (librarian == null) {
      throw new RuntimeException("Librarian not present.");
    }
    if (!checkedOutMediaByPatron.get(patron).isEmpty()) {
      throw new MediaItemCheckedOutException("Cannot remove patron with checked out media.");
    }
    patrons.remove(patron);
    checkedOutMediaByPatron.remove(patron);
  }

  /**
   * Checks out a media item to a patron.
   *
   * @param item the media item to check out
   * @param patron the patron to check out the media item to
   * @return true if the media item was checked out, false otherwise
   */
  public boolean checkOutMediaItem(MediaItem item, Patron patron) {
    if (canCheckOutMediaItem(item, patron)) {
      checkedOutId.add(item.getUUID());
      checkedOutMediaByPatron.get(patron).add(item);
      return true;
    }
    return false;
  }

  /**
   * Checks in a media item from a patron.
   *
   * @param item the media item to check in
   * @param patron the patron to check in the media item from
   * @return true if the media item was checked in, false otherwise
   */
  private boolean canCheckOutMediaItem(MediaItem item, Patron patron) {
    return !isCheckedOut(item) && hasMediaItem(item) && hasPatron(patron);
  }

  /**
   * Checks in a media item from a patron.
   *
   * @param item the media item to check in
   * @param patron the patron to check in the media item from
   * @return true if the media item was checked in, false otherwise
   */
  public boolean isCheckedOut(MediaItem item) {
    return checkedOutId.contains(item.getUUID());
  }

  /**
   * Checks in a media item from a patron.
   *
   * @param item the media item to check in
   * @param patron the patron to check in the media item from
   * @return true if the media item was checked in, false otherwise
   */
  public boolean hasMediaItem(MediaItem item) {
    return mediaIds.contains(item.getUUID());
  }

  /** checks for Patron */
  public boolean hasPatron(Patron patron) {
    return patrons.contains(patron);
  }

  /** searches for media item by type */
  public List<MediaItem> searchByType(String type) {
    List<MediaItem> foundItems = new ArrayList<>();
    for (MediaItem item : mediaItemsMap.values()) {
      if (item.getType().equalsIgnoreCase(type)) {
        foundItems.add(item);
      }
    }
    return foundItems;
  }

  /** searches for media item by title */
  public Book searchByISBN(String isbn) {
    for (MediaItem item : mediaItemsMap.values()) {
      if (item instanceof Book && ((Book) item).getIsbn().equals(isbn)) {
        return (Book) item;
      }
    }
    return null;
  }

  /** searches for media item by author */
  public List<MediaItem> searchByAuthor(String author) {
    List<MediaItem> foundItems = new ArrayList<>();
    for (MediaItem item : mediaItemsMap.values()) {
      if (item instanceof Book) {
        Book book = (Book) item;
        if (book.getAuthors().contains(author)) {
          foundItems.add(item);
        }
      }
    }
    return foundItems;
  }

  /** searches for media item by UUID */
  public MediaItem searchByUUID(UUID uuid) {
    return mediaItemsMap.get(uuid);
  }

  /** searches for media item by title */
  public MediaItem searchByTitle(String title) {
    for (MediaItem item : mediaItemsMap.values()) {
      if (item.getTitle().equalsIgnoreCase(title)) {
        return item;
      }
    }
    return null;
  }

  /** checks for media item */
  public boolean hasBook(MediaItem item) {
    return mediaItemsMap.containsValue(item);
  }

  /** gets checked out media by patron */
  public Set<MediaItem> getCheckedOutByPatron(Patron patron) {
    return checkedOutMediaByPatron.getOrDefault(patron, Collections.emptySet());
  }
}
