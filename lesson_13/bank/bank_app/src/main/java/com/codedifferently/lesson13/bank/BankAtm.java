package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class BankAtm {
  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, CheckingAccount> accountByNumber = new HashMap<>();

  public void addAccount(CheckingAccount account) {
    accountByNumber.put(account.getAccountNumber(), account);
    account
        .getOwners()
        .forEach(
            owner -> {
              customerById.put(owner.getId(), owner);
            });
  }

  public Set<CheckingAccount> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts()
        : Set.of();
  }

  public void depositFunds(String accountNumber, double amount) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    account.deposit(amount);
  }

  public void depositFunds(String accountNumber, Check check) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    check.depositFunds(account);
  }

  public void withdrawFunds(String accountNumber, double amount) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    account.withdraw(amount);
  }

  private CheckingAccount getAccountOrThrow(String accountNumber) {
    CheckingAccount account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
  }
}
