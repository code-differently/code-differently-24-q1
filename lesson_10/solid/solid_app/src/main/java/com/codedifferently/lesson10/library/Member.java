package com.codedifferently.lesson10.library;

import java.util.Set;

import javax.print.attribute.standard.Media;

import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public interface Member {
  public Set<Media> getCheckedOutBooks();


  public void setLibrary(Library library) throws WrongLibraryException;

  public String getName();

  public String getId();
}
