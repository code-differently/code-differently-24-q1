package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  @Test
  void constructor_validAmount() {
    // Arrange
    double amount = 100.0;

    // Act
    MoneyOrder moneyOrder = new MoneyOrder(amount);

    // Assert
    assertEquals(amount, moneyOrder.getAmount());
  }

  @Test
  void constructor_negativeAmount() {
    // Arrange & Act & Assert
    assertThrows(IllegalArgumentException.class, () -> new MoneyOrder(-100.0));
  }

  @Test
  void depositFunds_withdrawFromAccount() {
    // Arrange
    double initialBalance = 150.0; // Ensure the initial balance covers the withdrawal amount
    double amount = 100.0;
    Set<Customer> owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe")); // Sample customer with a UUID
    CheckingAccount checkingAccount =
        new CheckingAccount(
            "123456789",
            owners,
            initialBalance,
            false); // Provide a boolean value for canWriteChecks
    MoneyOrder moneyOrder = new MoneyOrder(amount);

    // Act
    moneyOrder.depositFunds(checkingAccount);

    // Assert
    assertEquals(50.0, checkingAccount.getBalance());
  }
}
