package com.codedifferently.lesson10.library;

public interface Media {
  String getTitle();

  String getType();

  boolean canBeCheckedOutBy(Patron patron);
}
