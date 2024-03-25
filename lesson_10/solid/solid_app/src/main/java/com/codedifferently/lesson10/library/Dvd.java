package com.codedifferently.lesson10.library;

public class Dvd implements Media {

  private String title;
  private String director;
  private Boolean checkedOut;

  // constructor
  public Dvd(String title, String director, Boolean checkedOut) {
    this.title = title;
    this.director = director;
    this.checkedOut = false;
  }
@Override
  public String getTitle(){
  return title;
  }
  @Override
public String getDirector() {
  return director;
}
@Override
public boolean isCheckedOut(){
  return checkedOut;
}

@Override
public boolean checkOut(Librarian librarian) {
    if (!checkedOut && librarian != null) { // If not already checked out and librarian is present
        checkedOut = true; // Check out the DVD
        return true; // Return true to indicate successful checkout
    } else {
        return false; // Return false to indicate unsuccessful checkout
    }
    @Override
    public boolean returnItem() {
        if (checkedOut) { // If the DVD is checked out
            checkedOut = false; // Return the DVD
            return true; // Return true to indicate successful return
        } else {
            return false; // Return false to indicate unsuccessful return (DVD was not checked out)
        }
    }
}
}