package com.codedifferently.lesson13.bank;

import java.util.Set;

public class BusinessCheckingAccount extends CheckingAccount {
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
  }
}
