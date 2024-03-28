package com.codedifferently.lesson13.bank;


import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
/** Represents a checking account. */
public class CheckingAccount extends BankAccountBase implements BankAccounts{

  // constructor
  public CheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
  super(accountNumber,owners,initialBalance);
 
  }
}
