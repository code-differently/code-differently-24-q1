package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.*;
import java.util.Set;

public class CheckingAccount {
  private final Set<Customer> owners;
  private final String accountNumber;
  private double balance;
  private final boolean canWriteChecks;
  private boolean isActive;

  /**
   * Creates a new checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   * @param canWriteChecks Whether the account can write checks or not.
   */
  public CheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance, boolean canWriteChecks) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    this.canWriteChecks = canWriteChecks;
    isActive = true;
  }

  /**
   * Gets the account number.
   *
   * @return The account number.
   */
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * Gets the owners of the account.
   *
   * @return The owners of the account.
   */
  public Set<Customer> getOwners() {
    return owners;
  }

  /**
   * Deposits funds into the account.
   *
   * @param amount The amount to deposit.
   */
  public void deposit(double amount) throws IllegalStateException {
    if (isClosed()) {
      throw new IllegalStateException("Cannot deposit to a closed account");
    }
    if (amount <= 0) {
      throw new IllegalArgumentException("Deposit amount must be positive");
    }
    balance += amount;
  }

  /**
   * Withdraws funds from the account.
   *
   * @param amount
   * @throws InsufficientFundsException
   */
  public void withdraw(double amount) throws InsufficientFundsException {
    if (isClosed()) {
      throw new IllegalStateException("Cannot withdraw from a closed account");
    }
    if (amount <= 0) {
      throw new IllegalStateException("Withdrawal amount must be positive");
    }
    if (balance < amount) {
      throw new InsufficientFundsException("Account does not have enough funds for withdrawal");
    }
    balance -= amount;
  }

  /**
   * Gets the balance of the account.
   *
   * @return The balance of the account.
   */
  public double getBalance() {
    return balance;
  }

  /**
   * Closes the account if the balance is non-positive.
   *
   * @throws IllegalStateException if the account has a positive balance.
   */
  public void closeAccount() throws IllegalStateException {
    if (balance > 0) {
      throw new IllegalStateException("Cannot close account with a positive balance");
    }
    isActive = false;
  }

  /**
   * Checks if the account is closed.
   *
   * @return True if the account is closed, otherwise false.
   */
  public boolean isClosed() {
    return !isActive;
  }

  /**
   * Checks if the account can write checks.
   *
   * @return True if the account can write checks, otherwise false.
   */
  public boolean canWriteChecks() {
    return canWriteChecks;
  }

  /**
   * Gets the hash code of the account number.
   *
   * @return The hash code of the account number.
   */
  @Override
  public int hashCode() {
    return accountNumber.hashCode();
  }

  /**
   * Checks if the account is equal to another object.
   *
   * @param obj The object to compare.
   * @return True if the account is equal to the other object, otherwise false.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof CheckingAccount other) {
      return accountNumber.equals(other.accountNumber);
    }
    return false;
  }

  /**
   * Gets a string representation of the account.
   *
   * @return A string representation of the account.
   */
  @Override
  public String toString() {
    return "CheckingAccount{"
        + "accountNumber='"
        + accountNumber
        + '\''
        + ", balance="
        + balance
        + ", isActive="
        + isActive
        + ", canWriteChecks="
        + canWriteChecks
        + '}';
  }
}
