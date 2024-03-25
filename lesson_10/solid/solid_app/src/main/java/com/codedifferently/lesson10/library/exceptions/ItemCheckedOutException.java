package com.codedifferently.lesson10.library.exceptions;

public class ItemCheckedOutException extends RuntimeException {
  public ItemCheckedOutException(String message) {
    super(message);
  }
}
