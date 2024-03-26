package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.media.Dvd;
import java.util.List;

public class Librarian extends Patron {
  private List<Dvd> dvds;

  public Librarian(String id, String name) {
    super(id, name); // Updated constructor call with two arguments
  }

  public void addDvd(Dvd dvd) {
    dvds.add(dvd);
  }

  public void removeDvd(Dvd dvd) {
    dvds.remove(dvd);
  }

  // Additional methods and properties specific to Librarians
}
