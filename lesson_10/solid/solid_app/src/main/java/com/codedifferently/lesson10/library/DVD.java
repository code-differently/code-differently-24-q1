package com.codedifferently.lesson10.library;

/** Represents a DVD */
public class DVD extends MediaItem {
  private String rating;
  private String title;
  private String genre;

  /**
   * Constructor
   *
   * @param rating Motion Picture Association film rating
   * @param title the title of the DVD.
   * @param genre the movie/show genre of the DVD
   * @param library library DVD belongs to.
   */
  public DVD(String rating, String title, String genre, Library library) {
    this.rating = rating;
    this.title = title;
    this.genre = genre;
    this.library = library;
  }

  /**
   * Get the id of the dvd.
   *
   * @return The id of the dvd.
   */
  @Override
  public String getId() {
    return this.title;
  }

  @Override
  public boolean canOrCantCheckOut() {
    System.out.println("Enjoy your DVD!");
    return true;
  }
}
