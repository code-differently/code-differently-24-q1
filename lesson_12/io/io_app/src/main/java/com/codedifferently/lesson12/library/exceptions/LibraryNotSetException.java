package com.codedifferently.lesson12.library.exceptions;

public class LibraryNotSetException extends RuntimeException {
  public LibraryNotSetException(String message) {
    super(message);
  }
}
