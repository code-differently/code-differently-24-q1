package com.codedifferently.lesson16.library.exceptions;

public class LibraryNotSetException extends RuntimeException {
  public LibraryNotSetException(String message) {
    super(message);
  }
}
