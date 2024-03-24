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

  // Interface implements
  public void checkOutItem() {
    System.out.println(" Dvd is checked out ");
  }

  public void returnItem() {
    System.out.println(" Dvd is returned");
  }
}
