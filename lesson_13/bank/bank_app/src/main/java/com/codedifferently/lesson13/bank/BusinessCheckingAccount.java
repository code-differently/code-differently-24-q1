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
    super(accountNumber, owners, initialBalance);
  }

  /** Overrides the deposit method to ensure at least one owner is a business. */
  @Override
  public void deposit(double amount) {
    boolean hasBusinessOwner =
        getOwners().stream().anyMatch(owner -> owner instanceof BusinessCustomer);
    if (!hasBusinessOwner) {
      throw new IllegalArgumentException("At least one owner must be a business.");
    }
    super.deposit(amount);
  }
}
