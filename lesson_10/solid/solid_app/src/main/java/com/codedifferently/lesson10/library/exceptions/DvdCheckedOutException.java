package com.codedifferently.lesson10.library.exceptions;

public class DvdCheckedOutException extends RuntimeException {
  public DvdCheckedOutException(String message) {
    super(message);
  }
}
