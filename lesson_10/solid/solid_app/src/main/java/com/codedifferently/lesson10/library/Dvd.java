package com.codedifferently.lesson10.library;

public class Dvd implements Media {

  private String title;
  private String director;
  private Boolean checkedOut;
  private Boolean returnItem;

  // constructor
  public Dvd(String title, String director, Boolean checkedOut) {
    this.title = title;
    this.director = director;
    this.checkedOut = false;
    this.returnItem = returnItem;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  @Override
  public boolean isCheckedOut() {
    return checkedOut;
  }

  public boolean isReturned() {
    return returnItem;
  }

  @Override
  public boolean checkOut(Librarian librarian) {
    if (!checkedOut && librarian != null) { // If not already checked out and librarian is present
      checkedOut = true; // Check out the DVD
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean returnItem() {

    if (checkedOut) { // If the DVD is checked out
      checkedOut = false; // Return the DVD
      return true;
    } else {
      return false;
    }
  }
}
