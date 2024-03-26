package com.codedifferently.lesson13.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson13.bank.exceptions.CheckVoidedException;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAtmTest {

  private BankAtm bankAtm;
  private CheckingAccount account1;
  private CheckingAccount account2;
  private Customer customer1;
  private Customer customer2;

  @BeforeEach
  void setUp() {
    bankAtm = new BankAtm();
    customer1 = new Customer(UUID.randomUUID(), "John Doe");
    customer2 = new Customer(UUID.randomUUID(), "Jane Smith");
    account1 = new CheckingAccount("123456789", Set.of(customer1), 100.0);
    account2 = new CheckingAccount("987654321", Set.of(customer1, customer2), 200.0);
    customer1.addAccount(account1);
    customer1.addAccount(account2);
    customer2.addAccount(account2);
    bankAtm.addAccount(account1);
    bankAtm.addAccount(account2);
  }

  @Test
  void testAddAccount() {
    Customer customer3 = new Customer(UUID.randomUUID(), "Alice Johnson");
    CheckingAccount account3 = new CheckingAccount("555555555", Set.of(customer3), 300.0);
    customer3.addAccount(account3);

    bankAtm.addAccount(account3);

    Set<CheckingAccount> accounts = bankAtm.findAccountsByCustomerId(customer3.getId());
    assertThat(accounts).containsOnly(account3);
  }

  @Test
  void testFindAccountsByCustomerId() {
    Set<CheckingAccount> accounts = bankAtm.findAccountsByCustomerId(customer1.getId());
    assertThat(accounts).containsOnly(account1, account2);
  }

  @Test
  void testDepositFunds() {
    bankAtm.depositFunds(account1.getAccountNumber(), 50.0);
    assertThat(account1.getBalance()).isEqualTo(150.0);
  }

  @Test
  void testDepositFunds_Check() {
    Check check = new Check("987654321", 100.0, account1);

    bankAtm.depositFunds("987654321", check);

    assertThat(account1.getBalance()).isEqualTo(0);
    assertThat(account2.getBalance()).isEqualTo(300.0);
  }

  @Test
  void testDepositFunds_DoesntDepositCheckTwice() {
    Check check = new Check("987654321", 100.0, account1);

    bankAtm.depositFunds("987654321", check);

    assertThatExceptionOfType(CheckVoidedException.class)
        .isThrownBy(() -> bankAtm.depositFunds("987654321", check))
        .withMessage("Check is voided");
  }

  @Test
  void testWithdrawFunds() {
    bankAtm.withdrawFunds(account2.getAccountNumber(), 50.0);
    assertThat(account2.getBalance()).isEqualTo(150.0);
  }

  @Test
  void testWithdrawFunds_AccountNotFound() {
    String nonExistingAccountNumber = "999999999";

    assertThatExceptionOfType(AccountNotFoundException.class)
        .isThrownBy(() -> bankAtm.withdrawFunds(nonExistingAccountNumber, 50.0))
        .withMessage("Account not found");
  }
}
