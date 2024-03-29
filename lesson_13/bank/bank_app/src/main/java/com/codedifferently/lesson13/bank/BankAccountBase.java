package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.Set;

public abstract class BankAccountBase implements BankAccounts {

  protected final Set<Customer> owners;
  protected final String accountNumber;
  protected double balance;
  protected boolean isActive;

  public BankAccountBase(String accountNumber, Set<Customer> owners, double initialBalance) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    isActive = true;
  }

  @Override
  public String getAccountNumber() {
    return accountNumber;
  }

  @Override
  public Set<Customer> getOwners() {
    return owners;
  }

  @Override
  public void deposit(double amount) throws IllegalStateException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void withdraw(double amount) throws InsufficientFundsException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public double getBalance() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void closeAccount() throws IllegalStateException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public boolean isClosed() {
    // Provide implementation for isClosed() method
    // For example, if you have a field indicating whether the account is closed:
    // return closed;
    return false; // Placeholder return value, change as per your logic
  }
}
