package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.HashSet;
import java.util.Set;


public class Librarian implements Member  {
  @Override
public Set<Media> getCheckedOutBooks(){
  return null;

}

  public  Library library;
  private String name;
  private String id;
  private Set<Media> checkedOutBooks;

// constructor 
public Librarian ( String name, String id ){
this.name = name;
this.id = id;
this.checkedOutBooks = new HashSet<>();
}
public void setLibrary(Library library) {
throws WrongLibraryException;
}

@Override
public String getName(){
return name;
}
@Override
public String getId(){
return id;
}
}