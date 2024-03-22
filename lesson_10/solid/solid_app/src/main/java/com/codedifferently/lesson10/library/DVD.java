package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.Library;

/** Represents a DVD */
public class DVD implements Assets {
  private String rating;
  private String title;
  private String genre;
  private Library library;

  /**
   * Constructor
   *
   * @param rating Motion Picture Association film rating
   * @param title the title of the DVD.
   * @param genre the movie/show genre of the DVD
   */
  public DVD(String rating, String title, String genre, Library library) {
    this.rating = rating;
    this.title = title;
    this.genre = genre;
    this.library = library;
  }

  @Override
  public void canOrCantCheckOut() {
    System.out.println("Enjoy your DVD!");
  }
}
