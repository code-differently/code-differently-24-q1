package com.codedifferently.lesson13.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson13.bank.exceptions.NoBusinessOwnersException;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BusinessCheckingAccountTest {
  private BankAccountBase classUnderTest;
  private Customer customer1;
  private Customer customer2;

  @BeforeEach
  void setUp() {
    customer1 = new Customer(UUID.randomUUID(), "ith", true);
    customer2 = new Customer(UUID.randomUUID(), "E Mh");

    classUnderTest = new BusinessCheckingAccount("1234232332", Set.of(customer2, customer1), 1000);
  }

  @Test
  void testConstructor_CantCreateCheckWithOutBusinessOwners() {
    // Act
    Customer customer3 = new Customer(UUID.randomUUID(), "Arron");
    // Assert
    assertThatExceptionOfType(NoBusinessOwnersException.class)
        .isThrownBy(
            () -> new BusinessCheckingAccount("123456889", Set.of(customer3, customer2), 100.0))
        .withMessage("A business owner must be one of the customers opening a business account.");
  }
}
