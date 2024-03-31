package com.codedifferently.lesson14.library.exceptions;

public class MediaItemCheckedOutException extends RuntimeException {
  public MediaItemCheckedOutException(String message) {
    super(message);
  }
}
