package com.codedifferently.lesson13.bank;

import java.util.Set;

public class SavingsAccount extends CheckingAccount {

 // Calls the constructor of the superclass (CheckingAccount) 
  public SavingsAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance); 
  }

  public void writeCheck(double amount) {
    throw new UnsupportedOperationException("Cannot write checks from a Savings Account");
  }
}
