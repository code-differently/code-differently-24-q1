package com.codedifferently.lesson10.jadaslibrary.exceptions;

public class WrongLibraryException extends RuntimeException {
  public WrongLibraryException(String message) {
    super(message);
  }
}
