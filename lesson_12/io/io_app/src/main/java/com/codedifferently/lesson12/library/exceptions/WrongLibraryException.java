package com.codedifferently.lesson12.library.exceptions;

public class WrongLibraryException extends RuntimeException {
  public WrongLibraryException(String message) {
    super(message);
  }
}
