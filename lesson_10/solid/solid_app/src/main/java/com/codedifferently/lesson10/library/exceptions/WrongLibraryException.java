package com.codedifferently.lesson10.library.exceptions;

public class WrongLibraryException extends RuntimeException {
  public WrongLibraryException(String message) {
    super(message);
  }
}
