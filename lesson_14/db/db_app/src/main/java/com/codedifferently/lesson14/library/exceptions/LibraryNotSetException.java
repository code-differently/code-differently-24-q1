package com.codedifferently.lesson14.library.exceptions;

public class LibraryNotSetException extends RuntimeException {
  public LibraryNotSetException(String message) {
    super(message);
  }
}
