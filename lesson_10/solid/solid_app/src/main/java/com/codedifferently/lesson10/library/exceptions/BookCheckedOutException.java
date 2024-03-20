package com.codedifferently.lesson10.library.exceptions;

public class BookCheckedOutException extends RuntimeException {
  public BookCheckedOutException(String message) {
    super(message);
  }
}
