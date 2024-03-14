package com.codedifferently.lesson7.chukwumaibezim;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {

  public static class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
      super(message);
    }
  }

  private String accountHolderName;
  private double balance;
  private String dateOpened;
  private String accountType;
  private final int accountNumber;

  public enum AccountType {
    CHECKING,
    SAVINGS,
    CD
  }

  private Map<Integer, String> additionalInfo = new HashMap<>();

  public BankAccount(
      String accountHolderName,
      double balance,
      String dateOpened,
      String accountType,
      int accountNumber) {
    this.accountHolderName = accountHolderName;
    this.balance = balance;
    this.dateOpened = dateOpened;
    this.accountType = accountType;
    this.accountNumber = accountNumber;
  }

  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getDateOpened() {
    return dateOpened;
  }

  public void setDateOpened(String dateOpened) {
    this.dateOpened = dateOpened;
  }

  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public void addAdditionalInfo(int key, String value) {
    additionalInfo.put(key, value);
  }

  public String getAdditionalInfo(int key) {
    return additionalInfo.get(key);
  }

  public void removeAdditionalInfo(int key) {
    additionalInfo.remove(key);
  }

  public void deposit(double amount) {
    balance += amount;
  }

  public void withdraw(double amount) throws InsufficientFundsException {
    if (balance >= amount) {
      balance -= amount;
    } else {
      throw new InsufficientFundsException("Insufficient funds to withdraw $" + amount);
    }
  }

  public void transfer(double amount, BankAccount account) throws InsufficientFundsException {
    if (balance >= amount) {
      balance -= amount;
      account.deposit(amount);
    } else {
      throw new InsufficientFundsException("Insufficient funds to transfer $" + amount);
    }
  }

  @Override
  public String toString() {
    return "Account Holder: "
        + accountHolderName
        + "\n"
        + "Balance: "
        + balance
        + "\n"
        + "Date Opened: "
        + dateOpened
        + "\n"
        + "Account Type: "
        + accountType
        + "\n"
        + "Account Number: "
        + accountNumber;
  }
}
