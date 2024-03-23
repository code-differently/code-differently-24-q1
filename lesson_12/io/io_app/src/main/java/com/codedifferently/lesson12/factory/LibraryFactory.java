package com.codedifferently.lesson12.factory;

import com.codedifferently.lesson12.library.Librarian;
import com.codedifferently.lesson12.library.Library;
import com.codedifferently.lesson12.library.LibraryGuest;
import com.codedifferently.lesson12.library.MediaItem;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** A factory class that creates a Library object with a LibraryDataLoader object. */
public class LibraryFactory {

  /**
   * Create a Library object with a LibraryDataLoader object.
   *
   * @param loader A LibraryDataLoader object.
   * @return A Library object.
   * @throws IOException
   */
  public static Library createWithLoader(LibraryDataLoader loader) throws IOException {
    Library library = new Library("main-library");

    // Load library data.
    LibraryDataModel data = loader.loadData();

    // Organize media items and guests.
    List<MediaItem> mediaItems = data.getMediaItems();
    Map<String, MediaItem> mediaItemById = getMediaItemsById(mediaItems);
    List<LibraryGuest> guests = data.getGuests();
    Map<String, LibraryGuest> guestsByEmail = getGuestsByEmail(guests);
    Librarian firstLibrarian = findFirstLibrarian(guests);
    Map<String, List<CheckoutModel>> checkoutsByEmail = data.getCheckoutsByEmail();

    // Add guests and media items to library
    addLibraryGuests(library, guests);
    addLibraryItems(library, mediaItems, firstLibrarian);
    checkOutItems(library, checkoutsByEmail, guestsByEmail, mediaItemById);

    return library;
  }

  private static Map<String, MediaItem> getMediaItemsById(List<MediaItem> mediaItems) {
    Map<String, MediaItem> mediaItemById = new HashMap<>();
    for (MediaItem mediaItem : mediaItems) {
      mediaItemById.put(mediaItem.getId(), mediaItem);
    }
    return mediaItemById;
  }

  private static Librarian findFirstLibrarian(List<LibraryGuest> guests) {
    Librarian firstLibrarian = null;
    for (LibraryGuest guest : guests) {
      if (guest instanceof Librarian librarian) {
        firstLibrarian = librarian;
      }
    }
    return firstLibrarian;
  }

  private static void addLibraryGuests(Library library, List<LibraryGuest> guests) {
    for (LibraryGuest guest : guests) {
      library.addLibraryGuest(guest);
    }
  }

  private static void addLibraryItems(
      Library library, List<MediaItem> mediaItems, Librarian firstLibrarian) {
    for (MediaItem mediaItem : mediaItems) {
      library.addMediaItem(mediaItem, firstLibrarian);
    }
  }

  private static Map<String, LibraryGuest> getGuestsByEmail(List<LibraryGuest> guests) {
    Map<String, LibraryGuest> guestByEmail = new HashMap<>();
    for (LibraryGuest guest : guests) {
      guestByEmail.put(guest.getEmail(), guest);
    }
    return guestByEmail;
  }

  private static void checkOutItems(
      Library library,
      Map<String, List<CheckoutModel>> checkoutsByEmail,
      Map<String, LibraryGuest> guestByEmail,
      Map<String, MediaItem> mediaItemById) {
    for (Map.Entry<String, List<CheckoutModel>> entry : checkoutsByEmail.entrySet()) {
      String email = entry.getKey();
      List<CheckoutModel> checkouts = entry.getValue();
      LibraryGuest guest = guestByEmail.get(email);
      for (CheckoutModel checkout : checkouts) {
        MediaItem mediaItem = mediaItemById.get(checkout.itemId);
        library.checkOutMediaItem(mediaItem, guest);
      }
    }
  }
}
