package com.codedifferently.lesson10.library.exceptions;

public class MediaItemCheckedOutException extends RuntimeException {
  public MediaItemCheckedOutException(String message) {
    super(message);
  }
}
