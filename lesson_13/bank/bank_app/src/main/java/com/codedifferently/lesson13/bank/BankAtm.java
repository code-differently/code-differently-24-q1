package com.codedifferently.lesson13.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;

/** Represents a bank ATM. */
public class BankAtm {
  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, BankAccounts> accountByNumber = new HashMap<>();

  /**
   * Adds a checking account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(BankAccounts account) {
    accountByNumber.put(account.getAccountNumber(), account);
    account
        .getOwners()
        .forEach(
            owner -> {
              customerById.put(owner.getId(), owner);
            });
  }

  /**
   * Finds all accounts owned by a customer.
   *
   * @param customerId The ID of the customer.
   * @return The unique set of accounts owned by the customer.
   */
  public Set<BankAccounts> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts()
        : Set.of();
  }

  /**
   * Deposits funds into an account.
   *
   * @param accountNumber The account number.
   * @param amount The amount to deposit.
   */
  public void depositFunds(String accountNumber, double amount) {
    BankAccounts account = getAccountOrThrow(accountNumber);
    account.deposit(amount);
  }

  /**
   * Deposits funds into an account using a check.
   *
   * @param accountNumber The account number.
   * @param check The check to deposit.
   */
  public void depositFunds(String accountNumber, Check check) {
    BankAccounts account = getAccountOrThrow(accountNumber);
    if (account instanceof CheckingAccount checkingAccount) {
      check.depositFunds(checkingAccount);
  } else if (account instanceof SavingsAccount) {
      throw new IllegalArgumentException("Cannot deposit check into savings account.");
  } else {
      throw new IllegalArgumentException("Unsupported account type.");
  }
}
  

  /**
   * Withdraws funds from an account.
   *
   * @param accountNumber
   * @param amount
   */
  public void withdrawFunds(String accountNumber, double amount) {
    BankAccounts account = getAccountOrThrow(accountNumber);
    account.withdraw(amount);
  }

  /**
   * Gets an account by its number or throws an exception if not found.
   *
   * @param accountNumber The account number.
   * @return The account.
   */
  private BankAccounts getAccountOrThrow(String accountNumber) {
    BankAccounts account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
  }
}
