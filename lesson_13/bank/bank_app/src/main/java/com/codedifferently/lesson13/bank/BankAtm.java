package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a bank ATM. */
public class BankAtm {
  public AuditLog atmLog = new AuditLog();
  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, BankAccount> accountByNumber = new HashMap<>();

  /**
   * Adds a checking account to the bank. Adds a bank account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(BankAccount account) {
    atmLog.document(account, "Added Account to BankAtm.");
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
  public Set<BankAccount> findAccountsByCustomerId(UUID customerId) {
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
    BankAccount account = getAccountOrThrow(accountNumber);
    atmLog.document(account, "Deposited " + amount + " into account.");
    account.deposit(amount);
  }

  /**
   * Deposits funds into an account using a check.
   *
   * @param accountNumber The account number.
   * @param check The check to deposit.
   */
  public void depositFunds(String accountNumber, Check check) {
    BankAccount account = getAccountOrThrow(accountNumber);
    atmLog.document(account, "Deposited " + check.toString() + " into account.");
    check.depositFunds(account);
  }

  /**
   * Withdraws funds from an account.
   *
   * @param accountNumber
   * @param amount
   */
  public void withdrawFunds(String accountNumber, double amount) {
    BankAccount account = getAccountOrThrow(accountNumber);
    atmLog.document(account, "Withdrawn " + amount + " from account.");
    account.withdraw(amount);
  }

  /**
   * Gets an account by its number or throws an exception if not found.
   *
   * @param accountNumber The account number.
   * @return The account.
   */
  private BankAccount getAccountOrThrow(String accountNumber) {
    BankAccount account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
  }
}
