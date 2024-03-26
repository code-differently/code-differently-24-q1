package com.codedifferently.lesson13.bank;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Customer {
  private final UUID id;
  private final String name;
  private final Set<CheckingAccount> accounts = new HashSet<>();

  public Customer(UUID id, String name) {
    this.id = id;
    this.name = name;
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void addAccount(CheckingAccount account) {
    accounts.add(account);
  }

  public Set<CheckingAccount> getAccounts() {
    return accounts;
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
