package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BusinessCheckingAccountTest {

  @Test
  void testIsBusiness() {
    // Given
    Customer businessCustomer = new Customer(UUID.randomUUID(), "Denzel Washington");
    businessCustomer.setBusiness(true);

    Set<Customer> owners = new HashSet<>();
    owners.add(businessCustomer);

    BusinessCheckingAccount businessAccount =
        new BusinessCheckingAccount("123456789", owners, 1000.0);

    // Then
    assertTrue(businessAccount.isBusiness());
  }

  @Test
  void testIsNotBusiness() {
    // Given
    Customer nonBusinessCustomer = new Customer(UUID.randomUUID(), "Non Business Owner");

    Set<Customer> owners = new HashSet<>();
    owners.add(nonBusinessCustomer);

    BusinessCheckingAccount businessAccount =
        new BusinessCheckingAccount("987654321", owners, 500.0);

    // Then
    assertFalse(businessAccount.isBusiness());
  }

  @Test
  void testWithdrawalOverdraft() {
    // Given
    Customer businessCustomer = new Customer(UUID.randomUUID(), "Denzel Washington");
    businessCustomer.setBusiness(true);

    Set<Customer> owners = new HashSet<>();
    owners.add(businessCustomer);

    BusinessCheckingAccount businessAccount =
        new BusinessCheckingAccount("123456789", owners, 1000.0);

    // When & Then
    assertThrows(InsufficientFundsException.class, () -> businessAccount.withdraw(1500.0));
  }

  @Test
  void testDeposit() {
    // Given
    Customer businessCustomer = new Customer(UUID.randomUUID(), "Denzel Washington");
    businessCustomer.setBusiness(true);

    Set<Customer> owners = new HashSet<>();
    owners.add(businessCustomer);

    BusinessCheckingAccount businessAccount =
        new BusinessCheckingAccount("123456789", owners, 1000.0);

    // When
    businessAccount.deposit(500.0);

    // Then
    assertEquals(1500.0, businessAccount.getBalance());
  }

  @Test
  void testCloseAccountWithPositiveBalance() {
    // Given
    Customer businessCustomer = new Customer(UUID.randomUUID(), "Denzel Washington");
    businessCustomer.setBusiness(true);

    Set<Customer> owners = new HashSet<>();
    owners.add(businessCustomer);

    BusinessCheckingAccount businessAccount =
        new BusinessCheckingAccount("123456789", owners, 1000.0);

    // Then
    assertThrows(IllegalStateException.class, businessAccount::closeAccount);
  }
}
