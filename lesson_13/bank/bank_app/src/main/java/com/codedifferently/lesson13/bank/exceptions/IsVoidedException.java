package com.codedifferently.lesson13.bank.exceptions;

public class IsVoidedException extends RuntimeException {
  public IsVoidedException() {}

  public IsVoidedException(String message) {
    super(message);
  }
}
