package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.ItemCheckedOutException;
import java.util.ArrayList;
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
  private Map<String, Set<MediaItem>> checkedOutMediaByPatron = new HashMap<>();
  private Set<String> patronIds = new HashSet<>();
  private String id;

  /**
   * Create a new library with the given id.
   *
   * @param id The id of the library.
   */
  public Library(String id) {
    this.id = id;
  }

  public Set<UUID> getMediaIds() {
    return this.mediaIds;
  }

  /**
   * Get the id of the library.
   *
   * @return The id of the library.
   */
  public String getId() {
    return this.id;
  }

  /**
   * Returns media item based off id
   *
   * @param id unique id of item
   * @return media item.
   */
  public MediaItem getMediaItemById(UUID id) {
    return mediaItemsMap.get(id);
  }

  /**
   * @param title title of item.
   * @return list of items based off title.
   */
  public List<MediaItem> searchByTitle(String title) {
    List<MediaItem> foundItems = new ArrayList<>();
    for (UUID id : mediaIds) {
      MediaItem item = getMediaItemById(id);
      if (item != null && item.getTitle().equalsIgnoreCase(title)) {
        foundItems.add(item);
      }
    }
    return foundItems;
  }

  /**
   * Add a book to the library.
   *
   * @param librarian The librarian adding book.
   * @param item The item to add.
   */
  public void addMedia(MediaItem item, Librarian librarian) {
    if (librarian == null) {
      throw new IllegalArgumentException("Librarian needed to add media item.");
    }

    this.mediaIds.add(item.getId());
    item.setLibrary(this);
    mediaItemsMap.put(item.getId(), item);
  }

  /**
   * Remove media item from the library.
   *
   * @param item The item to remove.
   * @param librarian The librarian removing item.
   */
  public void removeMediaItem(MediaItem item, Librarian librarian) throws ItemCheckedOutException {
    if (this.isCheckedOut(item)) {
      throw new ItemCheckedOutException("Cannot remove checked out media.");
    }
    if (librarian == null) {
      throw new IllegalArgumentException("Librarian needed to remove media.");
    }
    this.mediaIds.remove(item.getId());
    item.setLibrary(null);
    mediaItemsMap.remove(item.getId(), item);
  }

  /**
   * Add a patron to the library.
   *
   * @param patron The patron to add.
   */
  public void addPatron(Patron patron) {
    this.patronIds.add(patron.getId());
    this.checkedOutMediaByPatron.put(patron.getId(), new HashSet<>());
    patron.setLibrary(this);
  }

  /**
   * Remove a patron from the library.
   *
   * @param patron The patron to remove.
   */
  public void removePatron(Patron patron) throws ItemCheckedOutException {
    if (this.checkedOutMediaByPatron.get(patron.getId()).size() > 0) {
      throw new ItemCheckedOutException("Cannot remove patron with checked out media.");
    }
    this.patronIds.remove(patron.getId());
    this.checkedOutMediaByPatron.remove(patron.getId());
    patron.setLibrary(null);
  }

  /**
   * Check out a book to a patron.
   *
   * @param item The item to check out.
   * @param patron The patron to check out the book to.
   * @return True if the book was checked out, false otherwise.
   */
  public boolean checkOutMediaItem(MediaItem item, Patron patron) {
    if (!this.canCheckOutMediaItem(item, patron)) {
      return false;
    }
    this.checkedOutId.add(item.getId());
    this.checkedOutMediaByPatron.get(patron.getId()).add(item);
    return true;
  }

  private boolean canCheckOutMediaItem(MediaItem item, Patron patron) {
    return item.canCheckOut()
        && this.hasMediaItem(item)
        && !this.isCheckedOut(item)
        && this.hasPatron(patron);
  }

  /**
   * Check if the library has the given book.
   *
   * @param item The item to check for.
   * @return True if the library has the book, false otherwise.
   */
  public boolean hasMediaItem(MediaItem item) {
    return this.mediaIds.contains(item.getId());
  }

  /**
   * Check if the given book is checked out.
   *
   * @param item The item to check.
   * @return True if the item is checked out, false otherwise.
   */
  public boolean isCheckedOut(MediaItem item) {
    return this.checkedOutId.contains(item.getId());
  }

  /**
   * Check if the library has the given patron.
   *
   * @param patron The patron to check for.
   * @return True if the library has the patron, false otherwise.
   */
  public boolean hasPatron(Patron patron) {
    return this.patronIds.contains(patron.getId());
  }

  /**
   * Return a book to the library.
   *
   * @param item The item to return.
   * @param patron The patron returning the book.
   * @return True if the book was returned, false otherwise.
   */
  public boolean checkInMediaItem(MediaItem item, Patron patron) {
    if (!this.hasMediaItem(item)) {
      return false;
    }
    this.checkedOutId.remove(item.getId());
    this.checkedOutMediaByPatron.get(patron.getId()).remove(item);
    return true;
  }

  /**
   * Get the books checked out by a patron.
   *
   * @param patron The patron to get the books for.
   * @return The books checked out by the patron.
   */
  public Set<MediaItem> getCheckedOutByPatron(Patron patron) {
    return this.checkedOutMediaByPatron.get(patron.getId());
  }

  @Override
  public String toString() {
    return "Library{"
        + "mediaIds="
        + mediaIds
        + ", checkedOutId="
        + checkedOutId
        + ", checkedOutMediaByPatron="
        + checkedOutMediaByPatron
        + ", patronIds="
        + patronIds
        + '}';
  }
}
