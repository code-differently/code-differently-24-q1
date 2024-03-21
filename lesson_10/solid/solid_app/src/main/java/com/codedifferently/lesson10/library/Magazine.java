package com.codedifferently.lesson10.library;

import java.util.Objects;

/** Represents a magazine in a library. */
public class Magazine extends MediaItem {
  private String title;
  private String issue;
  private String category;

  /**
   * Create a new magazine with the given title, issue, and category.
   *
   * @param title The title of the magazine.
   * @param issue The issue of the magazine.
   * @param category The category of the magazine.
   */
  public Magazine(String title, String issue, String category) {
    this.title = title;
    this.issue = issue;
    this.category = category;
  }

  /**
   * Get the title of the magazine.
   *
   * @return The title of the magazine.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Get the issue of the magazine.
   *
   * @return The issue of the magazine.
   */
  public String getIssue() {
    return issue;
  }

  /**
   * Get the category of the magazine.
   *
   * @return The category of the magazine.
   */
  public String getCategory() {
    return category;
  }

  /**
   * Get the id of the magazine.
   *
   * @return The id of the magazine.
   */
  @Override
  public String getId() {
    return title + "-" + issue; // Assuming each issue of a magazine has a unique title
  }

  /**
   * Check if the given object is equal to this magazine.
   *
   * @param o The object to compare to.
   * @return True if the object is a magazine with the same title and issue, false otherwise.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Magazine)) return false;
    Magazine magazine = (Magazine) o;
    return Objects.equals(getTitle(), magazine.getTitle())
        && Objects.equals(getIssue(), magazine.getIssue());
  }

  /**
   * Get the hash code of the magazine.
   *
   * @return The hash code of the magazine.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  /**
   * Get a string representation of the magazine.
   *
   * @return A string representation of the magazine.
   */
  @Override
  public String toString() {
    return "Magazine{"
        + "id='"
        + getId()
        + '\''
        + ", title='"
        + title
        + '\''
        + ", issue='"
        + issue
        + '\''
        + '}';
  }
}
