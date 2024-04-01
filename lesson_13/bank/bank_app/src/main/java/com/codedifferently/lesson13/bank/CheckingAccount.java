package com.codedifferently.lesson13.bank;

import java.util.Set;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;

/** Represents a checking account. */
public class BankAccountBase implements BankAccount {
 
  /**
   * Creates a new checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public BankAccountBase(String accountNumber, Set<Customer> owners, double initialBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    isActive = true;
  }
 
 
  @Override
  public int hashCode() {
    return accountNumber.hashCode();
  }
 
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CheckingAccount other) {
      return accountNumber.equals(other.accountNumber);
    }
    return false;
  }
 
  @Override
  public String toString() {
    return "BankAccountBase{"
        + "accountNumber='"
        + accountNumber
        + '\''
        + ", balance="
        + balance
        + ", isActive="
        + isActive
        + '}';
  }
}