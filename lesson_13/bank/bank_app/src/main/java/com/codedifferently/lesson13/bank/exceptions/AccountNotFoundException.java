package com.codedifferently.lesson13.bank.exceptions;

public class AccountNotFoundException extends RuntimeException {
  public AccountNotFoundException() {}

  public AccountNotFoundException(String message) {
    super(message);
  }
}
