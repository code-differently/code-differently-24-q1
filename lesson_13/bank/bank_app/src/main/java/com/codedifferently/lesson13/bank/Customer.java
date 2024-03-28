package com.codedifferently.lesson13.bank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Represents a customer of the bank. */
public class Customer {
  private final UUID id;
  private final String name;
  private final Set<AccountType> accountTypes = new HashSet<>();
  private final Set<CheckingAccount> checkingAccounts = new HashSet<>();
  private final Set<SavingsAccount> savingsAccounts = new HashSet<>();
  private boolean isBusiness;

  /**
   * Creates a new customer.
   *
   * @param id The ID of the customer.
   * @param name The name of the customer.
   */
  public Customer(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Gets the ID of the customer.
   *
   * @return The ID of the customer.
   */
  public UUID getId() {
    return id;
  }

  /**
   * Gets the name of the customer.
   *
   * @return The name of the customer.
   */
  public String getName() {
    return name;
  }

  /**
   * Adds a checking account to the customer.
   *
   * @param account The account to add.
   */
  public void addCheckingAccount(CheckingAccount account) {
    checkingAccounts.add(account);
    accountTypes.add(AccountType.CONSUMER);
  }

  /**
   * Adds a savings account to the customer.
   *
   * @param account The account to add.
   */
  public void addSavingsAccount(SavingsAccount account) {
    savingsAccounts.add(account);
    accountTypes.add(AccountType.CONSUMER);
  }

  /**
   * Checks if the customer has a business account.
   *
   * @return True if the customer has a business account, otherwise false.
   */
  public boolean hasBusinessAccount() {
    return isBusiness;
  }

  /**
   * Sets the customer as a business customer.
   *
   * @param business True if the customer is a business customer, otherwise false.
   */
  public void setBusiness(boolean business) {
    isBusiness = business;
  }

  /**
   * Gets the types of accounts owned by the customer.
   *
   * @return The set of account types.
   */
  public Set<AccountType> getAccountTypes() {
    return accountTypes;
  }

  /**
   * Gets the checking accounts owned by the customer.
   *
   * @return The set of checking accounts.
   */
  public Set<CheckingAccount> getCheckingAccounts() {
    return checkingAccounts;
  }

  /**
   * Gets the savings accounts owned by the customer.
   *
   * @return The set of savings accounts.
   */
  public Set<SavingsAccount> getSavingsAccounts() {
    return savingsAccounts;
  }

  /**
   * Gets the hash code of the customer.
   *
   * @return The hash code of the customer.
   */
  @Override
  public int hashCode() {
    return id.hashCode();
  }

  /**
   * Checks if the customer is equal to another object.
   *
   * @param obj The object to compare.
   * @return True if the customer is equal to the object, otherwise false.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Customer other) {
      return id.equals(other.id);
    }
    return false;
  }

  /**
   * Gets the string representation of the customer.
   *
   * @return The string representation of the customer.
   */
  @Override
  public String toString() {
    return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
