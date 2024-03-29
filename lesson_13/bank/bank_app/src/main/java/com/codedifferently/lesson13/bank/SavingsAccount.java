package com.codedifferently.lesson13.bank;

import java.util.Set;

/** Represents a savings account. */
public class SavingsAccount extends CheckingAccount {

  /**
   * Creates a new savings account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  /** Overrides the withdraw method to disallow withdrawals from savings account. */
  @Override
  public void withdraw(double amount) {
    throw new UnsupportedOperationException("Withdrawals are not allowed from a savings account.");
  }
}
