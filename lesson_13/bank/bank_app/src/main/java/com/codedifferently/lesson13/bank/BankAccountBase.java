/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/**
 * @author vscode
 */
public abstract class BankAccountBase {

  protected final Set<Customer> owners;
  protected final String accountNumber;
  protected double balance;
  protected double initialBalance;
  protected boolean isActive;

  public BankAccountBase(String accountNumber, Set<Customer> owners, double initialBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.initialBalance = initialBalance;
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

  /** Closes the account. */
  
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
    return "CheckingAccount{"
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
