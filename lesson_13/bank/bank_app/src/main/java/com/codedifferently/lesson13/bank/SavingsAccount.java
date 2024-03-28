package com.codedifferently.lesson13.bank;

import java.util.Set;

/** Represents a savings account. */
public class SavingsAccount extends CheckingAccount {
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance, false); // Cannot write checks
  }

  /** Overrides the toString method to provide a string representation of the savings account. */
  @Override
  public String toString() {
    return String.format(
        "SavingsAccount{accountNumber='%s', balance=%.2f, isActive=%b}",
        getAccountNumber(), getBalance(), !isClosed());
  }
}
