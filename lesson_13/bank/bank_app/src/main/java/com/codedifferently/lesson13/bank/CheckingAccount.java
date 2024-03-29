package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/** Represents a checking account. */
public class CheckingAccount extends BankAccountBase implements BankAccounts {

  // constructor
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }

  public boolean isClosed() {
    // Provide implementation for isClosed() method
    // For example, if you have a field indicating whether the account is closed:
    // return closed;
    return false; // Placeholder return value, change as per your logic
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
}
