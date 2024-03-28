package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void testGetId() {
    UUID id = UUID.randomUUID();
    Customer customer = new Customer(id, "Denzel Washington");
    assertEquals(id, customer.getId());
  }

  @Test
  void testGetAccountTypes() {
    Customer customer = new Customer(UUID.randomUUID(), "Denzel Washington");
    assertFalse(customer.hasBusinessAccount());
  }

  @Test
  void testToString() {
    UUID id = UUID.randomUUID();
    Customer customer = new Customer(id, "Denzel Washington");
    String expected = "Customer{id=" + id + ", name='Denzel Washington'}";
    assertEquals(expected, customer.toString());
  }

  @Test
  void testHasBusinessAccount() {
    Customer customer = new Customer(UUID.randomUUID(), "Denzel Washington");
    assertFalse(customer.hasBusinessAccount());
  }

  @Test
  void testSetBusiness() {
    Customer customer = new Customer(UUID.randomUUID(), "Denzel Washington");
    assertFalse(customer.hasBusinessAccount());
    customer.setBusiness(true);
    assertTrue(customer.hasBusinessAccount());
  }

  @Test
  void testAddCheckingAccount() {
    Customer customer = new Customer(UUID.randomUUID(), "Denzel Washington");
    Set<Customer> owners = new HashSet<>();
    owners.add(customer);
    CheckingAccount checkingAccount = new CheckingAccount("123456789", owners, 100.0, false);
    customer.addCheckingAccount(checkingAccount);
    assertTrue(customer.getCheckingAccounts().contains(checkingAccount));
    assertTrue(customer.getAccountTypes().contains(AccountType.CONSUMER));
  }

  @Test
  void testAddSavingsAccount() {
    Customer customer = new Customer(UUID.randomUUID(), "Denzel Washington");
    Set<Customer> owners = new HashSet<>();
    owners.add(customer);
    SavingsAccount savingsAccount = new SavingsAccount("123456789", owners, 100.0);
    customer.addSavingsAccount(savingsAccount);
    assertTrue(customer.getSavingsAccounts().contains(savingsAccount));
    assertTrue(customer.getAccountTypes().contains(AccountType.CONSUMER));
  }
}
