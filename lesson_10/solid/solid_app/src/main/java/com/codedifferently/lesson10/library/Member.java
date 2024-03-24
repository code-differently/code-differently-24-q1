package com.codedifferently.lesson10.library;

import java.util.Set;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public interface Member {

  public void setLibrary(Library library) throws WrongLibraryException;

  public String getName();

  public String getId();

  public Set<LibraryitemInterface> getCheckedOutBooks() throws LibraryNotSetException;
}
