package com.codedifferently.lesson10.library.exceptions;

public class NoCheckoutException extends RuntimeException {
  public NoCheckoutException(String message) {
    super(message);
  }
}
