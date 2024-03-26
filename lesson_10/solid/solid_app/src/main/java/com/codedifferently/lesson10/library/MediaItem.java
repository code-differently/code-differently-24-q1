package com.codedifferently.lesson10.library;

import java.util.Objects;

/** Represents a media item in a library. */
public abstract class MediaItem {
  protected Library library;

  /** Get the library that the item is in. */
  public Library getLibrary() {
    return library;
  }

  /** Set the library that the item is in. */
  public void setLibrary(Library library) {
    this.library = library;
  }

  /** Get the id of the media item. */
  public abstract String getId();

  /** Get the title of the media item. */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MediaItem that = (MediaItem) o;
    return Objects.equals(library, that.library);
  }

  /** Get the hash code of the media item. */
  @Override
  public int hashCode() {
    return Objects.hash(library);
  }

  /** Get the string representation of the media item. */
  @Override
  public String toString() {
    return "MediaItem{" + "library=" + library + '}';
  }
}
