package com.codedifferently.lesson16.library.exceptions;

public class WrongLibraryException extends RuntimeException {
  public WrongLibraryException(String message) {
    super(message);
  }
}
