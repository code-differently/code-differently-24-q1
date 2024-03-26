package com.codedifferently.lesson12.library.exceptions;

public class MediaItemCheckedOutException extends RuntimeException {
  public MediaItemCheckedOutException(String message) {
    super(message);
  }
}
