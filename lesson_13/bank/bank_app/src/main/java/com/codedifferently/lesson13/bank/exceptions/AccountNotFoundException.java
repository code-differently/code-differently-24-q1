package com.codedifferently.lesson13.bank.exceptions;

public class AccountNotFoundException extends RuntimeException {
  public AccountNotFoundException() {
    super("Account not found");
  }

  public AccountNotFoundException(String message) {
    super(message);
  }
}
