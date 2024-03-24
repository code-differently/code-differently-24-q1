package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public interface Media {
  public String getId();

  public void setLibrary(Library library) throws WrongLibraryException;

  public String getTitle();

  public boolean isCheckedOut() throws LibraryNotSetException;

  void checkOutItem();

  void returnItem();
}
