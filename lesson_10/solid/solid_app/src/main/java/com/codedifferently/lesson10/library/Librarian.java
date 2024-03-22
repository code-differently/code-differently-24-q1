package com.codedifferently.lesson10.library;
import java.util;

// The Librarian class represents a librarian who manages the library
publi class Librarian {
    private String name;
    private List<MediaItem> mediaItems;

    public Librarian(String name) {
        this.name = name;
        this.mediaItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addMediaItem(String title, MediaType type) {
        mediaItems.add(new MediaItem(title, type));
        System.out.println(title + " added to the library.");
    }

    public void removeMediaItem(MediaItem item) {
        if (!item.isCheckedOut()) {
            mediaItems.remove(item);
            System.out.println(item.getTitle() + " removed from the library.");
        } else {
            System.out.println("Cannot remove " + item.getTitle() + ", it is currently checked out.");
        }
    }

    public void checkOutItem(Patron patron, MediaItem item) {
        patron.checkOutItem(item);
    }

    public void checkInItem(Patron patron, MediaItem item) {
        patron.checkInItem(item);
    }


    // enum data types are used to define a set of constants.
enum MediaTypes {
    BOOK,
    DVD,
    NEWSPAPER,
    MAGAZINE
}

}
