package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/** Represents a checking account. */
public class CheckingAccount {//extends BankAccountBase {
  
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance)
  super(accountNumber, owners, initialBalance);
}

