package com.codedifferently.lesson13.bank;

import java.util.Set;

/** Represents a checking account. */
public class CheckingAccount extends BankAccountBase implements BankAccounts {

  /**
   * @param accountNumber
   * @param owners
   * @param initialBalance
   */

  // constructor
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
