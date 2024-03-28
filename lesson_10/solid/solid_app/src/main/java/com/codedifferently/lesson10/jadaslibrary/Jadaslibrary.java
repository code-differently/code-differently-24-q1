package com.codedifferently.lesson10.jadaslibrary;

import java.util.ArrayList;
import java.util.List;

public class Jadaslibrary {
  private String id;
  private List<Book> books;
  private List<Patron> patrons;
  private List<MediaItem> mediaItems;
  private List<Librarian> librarians;
  public static final int MAX_CHECKED_OUT_MEDIA_ITEMS = 3;

  public Jadaslibrary(String id) {
    this.id = id;
    this.books = new ArrayList<>();
    this.patrons = new ArrayList<>();
    this.mediaItems = new ArrayList<>();
    this.librarians = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void removeBook(Book book) {
    books.remove(book);
  }

  public void addMediaItem(MediaItem mediaItem) {
    mediaItems.add(mediaItem);
    if (mediaItem instanceof Book) {
      books.add((Book) mediaItem);
    }
  }

  public void removeMediaItem(MediaItem mediaItem) {
    mediaItems.remove(mediaItem);
    if (mediaItem instanceof Book) {
      books.remove(mediaItem);
    }
  }

  public void registerPatron(Patron patron) {
    patrons.add(patron);
  }

  public void registerLibrarian(Librarian librarian) {
    librarians.add(librarian);
  }

  public void checkOutMediaItem(MediaItem mediaItem, Patron patron) {
    if (!mediaItem.isCheckedOut()
        && patron.getCheckedOutMediaItems().size() < MAX_CHECKED_OUT_MEDIA_ITEMS) {
      mediaItem.setCheckedOut(true);
      mediaItem.setPatron(patron);
    }
  }

  public void returnMediaItem(MediaItem mediaItem) {
    if (mediaItem.isCheckedOut()) {
      mediaItem.setCheckedOut(false);
      mediaItem.setPatron(null);
    }
  }

  public List<Book> getBooks() {
    return new ArrayList<>(books);
  }

  public List<MediaItem> getMediaItems() {
    return new ArrayList<>(mediaItems);
  }

  public List<Patron> getPatrons() {
    return new ArrayList<>(patrons);
  }

  public void addPatron(Patron patron) {
    patrons.add(patron);
  }

  public boolean hasBook(Book book) {
    return books.contains(book);
  }

  public boolean hasPatron(Patron patron) {
    return patrons.contains(patron);
  }

  public String getId() {
    return id;
  }

  public List<Book> getCheckedOutBooksByPatron(Patron patron) {
    List<Book> checkedOutBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.isCheckedOut() && book.getPatron().equals(patron)) {
        checkedOutBooks.add(book);
      }
    }
    return checkedOutBooks;
  }

  public List<MediaItem> getCheckedOutMediaItemsByPatron(Patron patron) {
    List<MediaItem> checkedOutMediaItems = new ArrayList<>();
    for (MediaItem mediaItem : mediaItems) {
      if (mediaItem.isCheckedOut() && mediaItem.getPatron().equals(patron)) {
        checkedOutMediaItems.add(mediaItem);
      }
    }
    return checkedOutMediaItems;
  }

  public boolean isCheckedOut(Book book) {
    return getCheckedOutBooks().contains(book);
  }

  private List<Book> getCheckedOutBooks() {
    List<Book> checkedOutBooks = new ArrayList<>();
    for (Book book : books) {
      if (book.isCheckedOut()) {
        checkedOutBooks.add(book);
      }
    }
    return checkedOutBooks;
  }

  public void removePatron(Patron patron) {
    patrons.remove(patron);
  }

  public void checkOutBook(Book book, Patron patron) {
    if (books.contains(book) && patrons.contains(patron)) {
      book.setCheckedOut(true);
      book.setPatron(patron);
    }
  }
}
