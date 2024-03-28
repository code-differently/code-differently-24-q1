package com.codedifferently.lesson13.bank;

import java.util.Set;

public class SavingsAccount extends BankAccountBase {
  public SavingsAccount(String accountNumber, Set<Customer> ownerrs, double initialBalance) {
    super(accountNumber, owners, initialBalance);
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
    return "SavingsAccount{"
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
