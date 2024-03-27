package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;

public class DVD extends MediaItem {

  public DVD(String title) throws MediaItemCheckedOutException {
    super(title);
    if (library != null) {
      throw new MediaItemCheckedOutException("DVD is already checked out");
    }
  }

  @Override
  public void checkOut() {}
}
