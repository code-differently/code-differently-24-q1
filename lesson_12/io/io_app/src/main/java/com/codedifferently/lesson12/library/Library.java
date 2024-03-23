package com.codedifferently.lesson12.library;

import com.codedifferently.lesson12.library.exceptions.MediaItemCheckedOutException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a library. */
public class Library {
  private final Set<UUID> itemIds = new HashSet<>();
  private final Set<UUID> checkedOutItemIds = new HashSet<>();
  private final Map<String, Set<MediaItem>> checkedOutItemsByGuest = new HashMap<>();
  private final Set<String> guestIds = new HashSet<>();
  private final String id;

  /**
   * Create a new library with the given id.
   *
   * @param id The id of the library.
   */
  public Library(String id) {
    this.id = id;
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
   * Add a item to the library.
   *
   * @param item The item to add.
   * @param librarian The librarian adding the item.
   */
  public void addMediaItem(MediaItem item, Librarian librarian) {
    this.itemIds.add(item.getId());
    item.setLibrary(this);
  }

  /**
   * Remove a item from the library.
   *
   * @param item The item to remove.
   * @param librarian The librarian removing the item.
   */
  public void removeMediaItem(MediaItem item, Librarian librarian)
      throws MediaItemCheckedOutException {
    if (this.isCheckedOut(item)) {
      throw new MediaItemCheckedOutException("Cannot remove checked out item.");
    }
    this.itemIds.remove(item.getId());
    item.setLibrary(null);
  }

  /**
   * Add a guest to the library.
   *
   * @param guest The guest to add.
   */
  public void addLibraryGuest(LibraryGuest guest) {
    this.guestIds.add(guest.getId());
    this.checkedOutItemsByGuest.put(guest.getId(), new HashSet<>());
    guest.setLibrary(this);
  }

  /**
   * Remove a guest from the library.
   *
   * @param guest The guest to remove.
   */
  public void removeLibraryGuest(LibraryGuest guest) throws MediaItemCheckedOutException {
    if (!this.checkedOutItemsByGuest.get(guest.getId()).isEmpty()) {
      throw new MediaItemCheckedOutException("Cannot remove guest with checked out items.");
    }
    this.guestIds.remove(guest.getId());
    this.checkedOutItemsByGuest.remove(guest.getId());
    guest.setLibrary(null);
  }

  /**
   * Check out a item to a guest.
   *
   * @param item The item to check out.
   * @param guest The guest to check out the item to.
   * @return True if the item was checked out, false otherwise.
   */
  public boolean checkOutMediaItem(MediaItem item, LibraryGuest guest) {
    if (!this.canCheckOutMediaItem(item, guest)) {
      return false;
    }
    this.checkedOutItemIds.add(item.getId());
    this.checkedOutItemsByGuest.get(guest.getId()).add(item);
    return true;
  }

  private boolean canCheckOutMediaItem(MediaItem item, LibraryGuest guest) {
    if (!item.canCheckOut()) {
      return false;
    }
    if (!this.hasMediaItem(item)) {
      return false;
    }
    if (this.isCheckedOut(item)) {
      return false;
    }
    if (!this.hasLibraryGuest(guest)) {
      return false;
    }
    return true;
  }

  /**
   * Check if the library has the given item.
   *
   * @param item The item to check for.
   * @return True if the library has the item, false otherwise.
   */
  public boolean hasMediaItem(MediaItem item) {
    return this.itemIds.contains(item.getId());
  }

  /**
   * Check if the given item is checked out.
   *
   * @param item The item to check.
   * @return True if the item is checked out, false otherwise.
   */
  public boolean isCheckedOut(MediaItem item) {
    return this.checkedOutItemIds.contains(item.getId());
  }

  /**
   * Check if the library has the given guest.
   *
   * @param guest The guest to check for.
   * @return True if the library has the guest, false otherwise.
   */
  public boolean hasLibraryGuest(LibraryGuest guest) {
    return this.guestIds.contains(guest.getId());
  }

  /**
   * Return a item to the library.
   *
   * @param item The item to return.
   * @param guest The guest returning the item.
   * @return True if the item was returned, false otherwise.
   */
  public boolean checkInMediaItem(MediaItem item, LibraryGuest guest) {
    if (!this.hasMediaItem(item)) {
      return false;
    }
    this.checkedOutItemIds.remove(item.getId());
    this.checkedOutItemsByGuest.get(guest.getId()).remove(item);
    return true;
  }

  /**
   * Get the items checked out by a guest.
   *
   * @param guest The guest to get the items for.
   * @return The items checked out by the guest.
   */
  public Set<MediaItem> getCheckedOutByGuest(LibraryGuest guest) {
    return this.checkedOutItemsByGuest.get(guest.getId());
  }

  @Override
  public String toString() {
    return "Library{"
        + "itemIds="
        + itemIds
        + ", checkedOutItemIds="
        + checkedOutItemIds
        + ", checkedOutMediaItemsByLibraryGuest="
        + checkedOutItemsByGuest
        + ", guestIds="
        + guestIds
        + '}';
  }
}
