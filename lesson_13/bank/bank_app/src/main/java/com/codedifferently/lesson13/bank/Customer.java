package com.codedifferently.lesson13.bank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/** Represents a customer of the bank. */
public class Customer {
  protected final UUID id;
  protected final String name;
  protected final Set<BankAccountBase> accounts = new HashSet<>();
  protected boolean isBusiness = false;

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
   * Creates a new customer with the ablility to add if it is a busness.
   *
   * @param id The ID of the customer.
   * @param name The name of the customer.
   * @param isBusiness The status of if it is a business
   */
  public Customer(UUID id, String name, boolean isBusiness) {
    this.id = id;
    this.name = name;
    this.isBusiness = isBusiness;
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
  public void addAccount(BankAccountBase account) {
    accounts.add(account);
  }

  /**
   * Gets the accounts owned by the customer.
   *
   * @return The unique set of accounts owned by the customer.
   */
  public Set<BankAccountBase> getAccounts() {
    return accounts;
  }

  public boolean isCustomerABusiness() {
    return isBusiness;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Customer other) {
      return id.equals(other.id);
    }
    return false;
  }

  @Override
  public String toString() {
    return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
