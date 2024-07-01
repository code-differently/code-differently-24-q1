package com.codedifferently.lesson10.library.exceptions;

public class LibraryNotSetException extends RuntimeException {
  public LibraryNotSetException(String message) {
    super(message);
  }
}
