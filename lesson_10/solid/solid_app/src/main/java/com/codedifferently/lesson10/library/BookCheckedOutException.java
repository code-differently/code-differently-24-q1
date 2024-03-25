package com.codedifferently.lesson10.library;

public class BookCheckedOutException extends Exception {
  public BookCheckedOutException(String message) {
    super(message);
  }
}
