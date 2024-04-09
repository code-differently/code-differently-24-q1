package com.codedifferently.lesson18.library.exceptions;

public class MediaItemCheckedOutException extends RuntimeException {
  public MediaItemCheckedOutException(String message) {
    super(message);
  }
}
