package com.codedifferently.lesson10.library;

// Dvd class

public class Dvd implements Media {

  private String title;
  private String director;
  private boolean checkedOut;

  public Dvd(String title, String director) {

    this.title = title;
    this.director = director;
    this.checkedOut = false;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public boolean isCheckedOut() {
    return checkedOut;
  }


  public boolean checkedOut(Librarian librarian) {
    // if librarian is not not there then checkedOut is true
    if (librarian = !null) {
      checkedOut = true;
      return true;
    } else {
      System.out.println("A librarian must be present to check out the Dvd.");
      return false;
    }
  }
}