package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson13.bank.BusinessCustomer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/** Represents a bank ATM. */
public class BankAtm {
  private final Map<UUID, Customer> customerById = new HashMap<>();
  private final Map<String, CheckingAccount> accountByNumber = new HashMap<>();

  /**
   * Adds a checking account to the bank.
   *
   * @param account The account to add.
   */
  public void addAccount(CheckingAccount account) {
    boolean isBusinessAccount = false;
    for (Customer owner : account.getOwners()) {
        if (owner instanceof BusinessCustomer) {
            isBusinessAccount = true;
            break;
        }
    }
    if (isBusinessAccount) {
        accountByNumber.put(account.getAccountNumber(), account);
        account.getOwners().forEach(owner -> customerById.put(owner.getId(), owner));
    } else {
        System.out.println("At least one owner of a BusinessCheckingAccount must be a business entity.");
    }
  }


  /**
   * Finds all accounts owned by a customer.
   *
   * @param customerId The ID of the customer.
   * @return The unique set of accounts owned by the customer.
   */
  public Set<CheckingAccount> findAccountsByCustomerId(UUID customerId) {
    return customerById.containsKey(customerId)
        ? customerById.get(customerId).getAccounts()
        : Set.of();
  }


  /**
     * Deposits funds into an account using a financial instrument (e.g., Check or MoneyOrder).
     *
     * @param accountNumber The account number.
     * @param financialInstrument The financial instrument (e.g., Check or MoneyOrder).
     */
    public void depositFunds(String accountNumber, MoneyOrder moneyOrder) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    double amount = moneyOrder.getAmount();
    account.deposit(amount);
    System.out.println("Funds deposited successfully using money order.");
}



  /**
     * Withdraws funds from an account using a financial instrument (e.g., Check or MoneyOrder).
     *
     * @param accountNumber The account number.
     * @param financialInstrument The financial instrument (e.g., Check or MoneyOrder).
     */
    public void withdrawFunds(String accountNumber, FinancialInstrument financialInstrument) {
    CheckingAccount account = getAccountOrThrow(accountNumber);
    double amount = financialInstrument.withdrawFunds();
    account.withdraw(amount);
    
    System.out.println("Funds withdrawn successfully using financial instrument.");
}



  /**
   * Gets an account by its number or throws an exception if not found.
   *
   * @param accountNumber The account number.
   * @return The account.
   */
  private CheckingAccount getAccountOrThrow(String accountNumber) {
    CheckingAccount account = accountByNumber.get(accountNumber);
    if (account == null || account.isClosed()) {
      throw new AccountNotFoundException("Account not found");
    }
    return account;
    }

}      

