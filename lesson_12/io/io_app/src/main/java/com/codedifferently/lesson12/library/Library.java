package com.codedifferently.lesson12.library;

import com.codedifferently.lesson12.library.exceptions.MediaItemCheckedOutException;
import com.codedifferently.lesson12.library.search.CatalogSearcher;
import com.codedifferently.lesson12.library.search.SearchCriteria;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a library. */
public class Library {
  private final Map<UUID, MediaItem> itemsById = new HashMap<>();
  private final Set<UUID> checkedOutItemIds = new HashSet<>();
  private final Map<String, Set<MediaItem>> checkedOutItemsByGuest = new HashMap<>();
  private final Map<String, LibraryGuest> guestsById = new HashMap<>();
  private final String id;
  private final CatalogSearcher<MediaItem> searcher;

  /**
   * Create a new library with the given id.
   *
   * @param id The id of the library.
   */
  public Library(String id) {
    this.id = id;
    this.searcher = new CatalogSearcher(this.itemsById.values());
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
    this.itemsById.put(item.getId(), item);
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
    this.itemsById.remove(item.getId());
    item.setLibrary(null);
  }

  /**
   * Search the library for items matching the given query.
   *
   * @param query The query to search for.
   * @return The items matching the query.
   */
  public Set<MediaItem> search(SearchCriteria query) {
    return new HashSet<>(this.searcher.search(query));
  }

  /**
   * Add a guest to the library.
   *
   * @param guest The guest to add.
   */
  public void addLibraryGuest(LibraryGuest guest) {
    this.guestsById.put(guest.getId(), guest);
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
    this.guestsById.remove(guest.getId());
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
    return this.hasLibraryGuest(guest);
  }

  /**
   * Check if the library has the given item.
   *
   * @param item The item to check for.
   * @return True if the library has the item, false otherwise.
   */
  public boolean hasMediaItem(MediaItem item) {
    return this.itemsById.containsKey(item.getId());
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
    return this.guestsById.containsKey(guest.getId());
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

  /**
   * Get a snapshot of the library info.
   *
   * @return The library info.
   */
  public LibraryInfo getInfo() {
    Map<String, Set<MediaItem>> itemsByGuest =
        this.checkedOutItemsByGuest.entrySet().stream()
            .collect(
                HashMap::new,
                (map, entry) ->
                    map.put(
                        entry.getKey(),
                        Collections.unmodifiableSet(new HashSet<>(entry.getValue()))),
                HashMap::putAll);
    return LibraryInfo.builder()
        .id(this.id)
        .items(Collections.unmodifiableSet(new HashSet<>(this.itemsById.values())))
        .guests(Collections.unmodifiableSet(new HashSet<>(this.guestsById.values())))
        .checkedOutItemsByGuest(Collections.unmodifiableMap(itemsByGuest))
        .build();
  }

  @Override
  public String toString() {
    return "Library{"
        + "itemsById="
        + itemsById
        + ", checkedOutItemIds="
        + checkedOutItemIds
        + ", checkedOutMediaItemsByLibraryGuest="
        + checkedOutItemsByGuest
        + ", guestIds="
        + guestsById
        + '}';
  }
}
