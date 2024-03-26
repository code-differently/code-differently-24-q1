package com.codedifferently.lesson13.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckingAccountTest {
  private CheckingAccount checkingAccount;
  private Set<Customer> owners;

  @BeforeEach
  void setUp() {
    owners = new HashSet<>();
    owners.add(new Customer(UUID.randomUUID(), "John Doe"));
    owners.add(new Customer(UUID.randomUUID(), "Jane Smith"));
    checkingAccount = new CheckingAccount("123456789", owners, 100.0);
  }

  @Test
  void getAccountNumber() {
    assertEquals("123456789", checkingAccount.getAccountNumber());
  }

  @Test
  void getOwners() {
    assertEquals(owners, checkingAccount.getOwners());
  }

  @Test
  void deposit() {
    checkingAccount.deposit(50.0);
    assertEquals(150.0, checkingAccount.getBalance());
  }

  @Test
  void deposit_withNegativeAmount() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> checkingAccount.deposit(-50.0));
  }

  @Test
  void withdraw() {
    checkingAccount.withdraw(50.0);
    assertEquals(50.0, checkingAccount.getBalance());
  }

  @Test
  void withdraw_withNegativeAmount() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> checkingAccount.withdraw(-50.0))
        .withMessage("Withdrawal amount must be positive");
  }

  @Test
  void withdraw_withInsufficientBalance() {
    assertThatExceptionOfType(InsufficientFundsException.class)
        .isThrownBy(() -> checkingAccount.withdraw(150.0))
        .withMessage("Account does not have enough funds for withdrawal");
  }

  @Test
  void getBalance() {
    assertEquals(100.0, checkingAccount.getBalance());
  }

  @Test
  void closeAccount_withPositiveBalance() {
    assertThatExceptionOfType(IllegalStateException.class)
        .isThrownBy(() -> checkingAccount.closeAccount());
  }

  @Test
  void isClosed() {
    assertFalse(checkingAccount.isClosed());
    checkingAccount.withdraw(100);
    checkingAccount.closeAccount();
    assertTrue(checkingAccount.isClosed());
  }

  @Test
  void equals() {
    CheckingAccount otherAccount = new CheckingAccount("123456789", owners, 200.0);
    assertEquals(checkingAccount, otherAccount);
  }

  @Test
  void hashCodeTest() {
    CheckingAccount otherAccount = new CheckingAccount("123456789", owners, 200.0);
    assertEquals(checkingAccount.hashCode(), otherAccount.hashCode());
  }

  @Test
  void toStringTest() {
    String expected = "CheckingAccount{accountNumber='123456789', balance=100.0, isActive=true}";
    assertEquals(expected, checkingAccount.toString());
  }
}
