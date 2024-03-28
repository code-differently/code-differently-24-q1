package com.codedifferently.lesson13.bank;

import java.util.Set;

/** Represents a business checking account. */
public class BusinessCheckingAccount extends CheckingAccount {

  /**
   * Creates a new business checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance, true); // Can write checks
  }

  /** Returns owners of the business account. */
  public boolean isBusiness() {
    Customer owner = getOwners().iterator().next();
    return owner.hasBusinessAccount();
  }
}
