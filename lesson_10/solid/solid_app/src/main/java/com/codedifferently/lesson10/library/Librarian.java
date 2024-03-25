package com.codedifferently.lesson10.library;

import java.util.HashSet;
import java.util.Set;

public class Librarian implements Member {

  private Library library;
  private String name;
  private String id;

  // constructor
  public Librarian(String name, String id) {
    this.name = name;
    this.id = id;
  }

  @Override
  public void setLibrary(Library library) {
    this.library = library;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public Set<Media> getCheckedOutMedia() {
    if (library == null) {
      return new HashSet<>();
    }
    return library.getCheckedOutMediaByPatron(this);
  }
}
