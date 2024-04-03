package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {

  private Set<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe", false)); // Update here
    owners.add(new Customer(UUID.randomUUID(), "Jane Smith", true)); // Update here
  }

  @Test
  void constructorTest() {
    CheckingAccount account = new CheckingAccount("123456", owners, 1000);
    assertEquals("123456", account.getAccountNumber());
    assertEquals(1000, account.getBalance());
    assertFalse(account.isClosed());
  }
}
