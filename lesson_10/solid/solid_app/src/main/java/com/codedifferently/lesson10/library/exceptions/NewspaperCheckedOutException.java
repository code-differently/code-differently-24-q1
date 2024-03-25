package com.codedifferently.lesson10.library.exceptions;

public class NewspaperCheckedOutException extends RuntimeException {
  public NewspaperCheckedOutException(String message) {
    super(message);
  }
}
