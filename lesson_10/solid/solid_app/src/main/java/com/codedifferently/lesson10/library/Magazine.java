package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;

public class Magazine extends MediaItem {

  public Magazine(String title) throws MediaItemCheckedOutException {
    super(title);
    this.title = title;
    if (library != null) {
      throw new MediaItemCheckedOutException("Magazine cannot be checked out");
    }
  }

  @Override
  public void checkOut() {}
}
