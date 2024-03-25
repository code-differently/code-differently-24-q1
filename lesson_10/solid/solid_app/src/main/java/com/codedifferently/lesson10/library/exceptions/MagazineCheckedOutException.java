package com.codedifferently.lesson10.library.exceptions;

public class MagazineCheckedOutException extends RuntimeException {
  public MagazineCheckedOutException(String message) {
    super(message);
  }
}
