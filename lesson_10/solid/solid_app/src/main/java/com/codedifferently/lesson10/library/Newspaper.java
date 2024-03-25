package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;

public class Newspaper extends MediaItem {

  public Newspaper(String title, Library library) throws MediaItemCheckedOutException {
    super(title);
    this.title = title;
    if (library != null) {
      throw new MediaItemCheckedOutException("Newspaper cannot be checked out");
    }
  }

  @Override
  public void checkOut() {}
}
