package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.HashSet;
import java.util.Set;


public class Librarian implements Member  {

  public  Library library;
  private String name;
  private String id;
  private Set<LibraryitemInterface> checkedOutBooks;

// constructor 
public Librarian ( String name, String id ){
this.name = name;
this.id = id;
this.checkedOutBooks = new HashSet<>();


}

    Object getCheckedOutBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Object getCheckedOutBooks() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
