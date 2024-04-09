package com.codedifferently.lesson18.library.exceptions;

public class LibraryNotSetException extends RuntimeException {
  public LibraryNotSetException(String message) {
    super(message);
  }
}
