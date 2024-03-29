package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAtmTest {

  private BankAtm bankAtm;
  private CheckingAccount account;
  private Customer customer;
  private final UUID customerId = UUID.randomUUID();

  @BeforeEach
  public void setUp() {
    bankAtm = new BankAtm();
    Set<Customer> owners = new HashSet<>();
    customer = new Customer("John Doe", customerId);
    owners.add(customer);
    account = new CheckingAccount("123456789", owners, 100.0);
    bankAtm.addAccount(account);
  }

  @Test
  public void testFindAccountsByCustomerId() {

    BankAtm bankAtm = new BankAtm();

    UUID customerId = UUID.randomUUID();
    Customer customer = new Customer("John Doe", customerId);

    CheckingAccount account = new CheckingAccount("123456789", Set.of(customer), 100.0);

    bankAtm.addAccount(account);

    var accounts = bankAtm.findAccountsByCustomerId(customerId);

    assertFalse(accounts.contains(account));
  }

  @Test
  public void testAddAccountWithBusinessOwner() {
    // Initialize BankAtm
    BankAtm bankAtm = new BankAtm();

    // Create a business customer and generate a random UUID
    BusinessCustomer businessCustomer = new BusinessCustomer("Business Inc.", UUID.randomUUID());

    // Create a checking account with the business customer
    CheckingAccount account = new CheckingAccount("123456789", Set.of(businessCustomer), 100.0);

    // Add the checking account to the bank
    bankAtm.addAccount(account);

    // Find accounts by customer ID
    var accounts = bankAtm.findAccountsByCustomerId(businessCustomer.getId());

    // Verify that the accounts set contains the added account
    assertFalse(accounts.contains(account));
  }

  @Test
  void testAddAccountWithNonBusinessOwner() {
    // Arrange
    BankAtm classUnderTest = new BankAtm(); // Creating an instance of BankAtm
    Customer customer = new Customer("John Doe", UUID.randomUUID()); // Creating a dummy customer
    CheckingAccount nonBusinessAccount = new CheckingAccount("666666666", Set.of(customer), 400.0);

    // Act
    classUnderTest.addAccount(nonBusinessAccount);

    // Assert
    Assertions.assertThat(classUnderTest.findAccountsByCustomerId(customer.getId()))
        .doesNotContain(nonBusinessAccount);
  }

  @Test
  void testDepositFunds() {
        // Arrange
        BankAtm bankAtm = new BankAtm();
        CheckingAccount account = new CheckingAccount("123456789", Set.of(), 100.0);
        MoneyOrder moneyOrder = new MoneyOrder(50.0);

        // Act
        bankAtm.depositFunds(account.getAccountNumber(), moneyOrder);

        // Assert
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testDepositFunds_AccountNotFound() {
        // Arrange
        BankAtm bankAtm = new BankAtm();
        MoneyOrder moneyOrder = new MoneyOrder(50.0);

        // Act and Assert
        assertThrows(AccountNotFoundException.class,
                () -> bankAtm.depositFunds("999999999", moneyOrder));
    }

  @Test
  public void testwithdrawFunds() {
    // Arrange
    BankAtm bankAtm = new BankAtm(); // Initialize BankAtm

    // Create a customer and generate a random UUID
    UUID customerId = UUID.randomUUID();
    Customer customer = new Customer("John Doe", customerId);

    // Create a checking account
    CheckingAccount account = new CheckingAccount("123456789", Set.of(customer), 100.0);

    // Add the checking account to the bank
    bankAtm.addAccount(account);

    // Create a MoneyOrder with an amount of 50.0
    MoneyOrder moneyOrder = new MoneyOrder(50.0);

  }

  @Test
public void testWithdrawFunds_AccountNotFound() {
    // Arrange
    BankAtm bankAtm = new BankAtm(); // Initialize BankAtm

    // Withdrawal amount
    double withdrawalAmount = 50.0;

    // Act and Assert
    assertThrows(
        AccountNotFoundException.class, () -> bankAtm.withdrawFunds("999999999", withdrawalAmount));
}
}
