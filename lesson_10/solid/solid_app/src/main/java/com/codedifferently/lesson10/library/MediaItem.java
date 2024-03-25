package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MediaItemCheckedOutException;

public abstract class MediaItem {

  protected String title;
  protected Library library;
  private boolean checkedOut;

  public MediaItem(String title) {
    this.title = title;
    this.checkedOut = false;
    this.library = null;
  }

  public abstract void checkOut() throws MediaItemCheckedOutException;

  public boolean isCheckedOut() {
    return checkedOut;
  }

  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  public String getTitle() {
    return title;
  }
  // public abstract void setCheckedOut(boolean c);
}
