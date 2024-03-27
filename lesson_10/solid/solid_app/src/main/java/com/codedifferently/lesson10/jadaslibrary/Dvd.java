package com.codedifferently.lesson10.jadaslibrary;

public class Dvd extends MediaItem {
  private String director;
  private int releaseYear;
  private boolean checkedOut;
  private Patron patron;

  public Dvd(String title, String director, int releaseYear) {
    super(title, "N/A", 0);
    this.director = director;
    this.releaseYear = releaseYear;
    this.patron = null;
  }

  // Getters and setters
  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  public String getId() {
    return getTitle();
  }

  @Override
  public Patron getPatron() {
    return patron;
  }

  @Override
  public void setPatron(Patron patron) {
    this.patron = patron;
  }

  @Override
  public boolean isCheckedOut() {
    return checkedOut;
  }

  @Override
  public void setCheckedOut(boolean checkedOut) {
    this.checkedOut = checkedOut;
  }

  @Override
  public String toString() {
    return "DVD{"
        + "title='"
        + getTitle()
        + '\''
        + ", director='"
        + director
        + '\''
        + ", releaseYear="
        + releaseYear
        + ", patron="
        + (patron != null ? patron.getName() : "None")
        + '}';
  }
}
