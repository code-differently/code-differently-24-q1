package com.codedifferently.lesson10.library;

import java.util.Objects;

/** Represents a DVD in a library. */
public class DVD extends MediaItem {
  private String title;
  private String director;
  private int duration;

    /**
     * Create a new DVD with the given title, director, and duration.
     *
     * @param title The title of the DVD.
     * @param director The director of the DVD.
     * @param duration The duration of the DVD.
     */
  public DVD(String title, String director, int duration) {
    this.title = title;
    this.director = director;
    this.duration = duration;
  }

  /**
   * Get the title of the DVD.
   *
   * @return The title of the DVD.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Get the director of the DVD.
   *
   * @return The director of the DVD.
   */
  public String getDirector() {
    return director;
  }

  /**
   * Get the duration of the DVD.
   *
   * @return The duration of the DVD.
   */
  public int getDuration() {
    return duration;
  }

  /**
   * Get the id of the DVD.
   *
   * @return The id of the DVD.
   */
  @Override
  public String getId() {
    return title; // Assuming title is unique for each DVD
  }

  /**
   * Check if the given object is equal to this DVD.
   *
   * @param o The object to compare to.
   * @return True if the object is a DVD with the same title, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof DVD)) return false;
    DVD dvd = (DVD) o;
    return Objects.equals(getTitle(), dvd.getTitle());
  }

  /**
   * Get the hash code of the DVD.
   *
   * @return The hash code of the DVD.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  /**
   * Get a string representation of the DVD.
   *
   * @return A string representation of the DVD.
   */
  @Override
  public String toString() {
    return "DVD{" + "id='" + getId() + '\'' + ", title='" + title + '\'' + '}';
  }
}
