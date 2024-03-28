package com.codedifferently.lesson13.bank.exceptions;

public class CheckVoidedException extends RuntimeException {
  public CheckVoidedException() {}

  public CheckVoidedException(String message) {
    super(message);
  }
}
