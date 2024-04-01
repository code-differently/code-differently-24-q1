package com.codedifferently.lesson13.bank.exceptions;

public class NoBusinessOwnersException extends RuntimeException {
  public NoBusinessOwnersException() {}

  public NoBusinessOwnersException(String message) {
    super(message);
  }
}
