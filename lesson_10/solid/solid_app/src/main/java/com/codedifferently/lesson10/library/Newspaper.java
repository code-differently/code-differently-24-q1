package com.codedifferently.lesson10.library;

import java.util.Objects;

/** A newspaper in a library. */
public class Newspaper extends MediaItem {
  private String title;
  private String date;

  /**
   * Create a new newspaper with the given title and date.
   *
   * @param title The title of the newspaper.
   * @param date The date of the newspaper.
   */
  public Newspaper(String title, String date) {
    this.title = title;
    this.date = date;
  }

  /**
   * Get the title of the newspaper.
   *
   * @return The title of the newspaper.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Get the date of the newspaper.
   *
   * @return The date of the newspaper.
   */
  public String getDate() {
    return date;
  }

  /**
   * Get the id of the newspaper.
   *
   * @return The id of the newspaper.
   */
  @Override
  public String getId() {
    return title + "-" + date; // Assuming each issue of a newspaper has a unique title
  }

  /**
   * Check if the given object is equal to this newspaper.
   *
   * @param o The object to compare to.
   * @return True if the object is a newspaper with the same title and date, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Newspaper)) return false;
    Newspaper newspaper = (Newspaper) o;
    return Objects.equals(getTitle(), newspaper.getTitle())
        && Objects.equals(getDate(), newspaper.getDate());
  }

  /**
   * Get the hash code of the newspaper.
   *
   * @return The hash code of the newspaper.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  /**
   * Get a string representation of the newspaper.
   *
   * @return A string representation of the newspaper.
   */
  @Override
  public String toString() {
    return "Newspaper{"
        + "id='"
        + getId()
        + '\''
        + ", title='"
        + title
        + '\''
        + ", date='"
        + date
        + '\''
        + '}';
  }
}
