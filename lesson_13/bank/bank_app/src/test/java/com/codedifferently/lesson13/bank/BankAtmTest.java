package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAtmTest {

  private BankAtm classUnderTest;
  private CheckingAccount account1;
  private CheckingAccount account2;
  private Customer customer1;
  private Customer customer2;

  @BeforeEach
  void setUp() {
    classUnderTest = new BankAtm();
    customer1 = new Customer(UUID.randomUUID(), "John Doe", false);
    customer2 = new Customer(UUID.randomUUID(), "Jane Smith", false);
    account1 = new CheckingAccount("123456789", Set.of(customer1), 100.0);
    account2 = new CheckingAccount("987654321", Set.of(customer1, customer2), 200.0);
    customer1.addAccount(account1);
    customer1.addAccount(account2);
    customer2.addAccount(account2);
    classUnderTest.addAccount(account1);
    classUnderTest.addAccount(account2);
  }

  @Test
  void findAccountsByCustomerIdTest() {
    Set<CheckingAccount> customer1Accounts =
        classUnderTest.findAccountsByCustomerId(customer1.getId());
    assertEquals(2, customer1Accounts.size());
    assertTrue(customer1Accounts.contains(account1));
    assertTrue(customer1Accounts.contains(account2));

    Set<CheckingAccount> customer2Accounts =
        classUnderTest.findAccountsByCustomerId(customer2.getId());
    assertEquals(1, customer2Accounts.size());
    assertTrue(customer2Accounts.contains(account2));
  }

  @Test
  void depositFundsTest() {
    classUnderTest.depositFunds(account1.getAccountNumber(), 50.0);
    assertEquals(150.0, account1.getBalance());
  }

  @Test
  void withdrawFundsTest() {
    classUnderTest.withdrawFunds(account2.getAccountNumber(), 50.0);
    assertEquals(150.0, account2.getBalance());
  }
}
