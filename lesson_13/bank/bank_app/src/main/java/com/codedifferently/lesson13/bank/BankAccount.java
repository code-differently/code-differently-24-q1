/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;
import java.util.Set;

/**
 * @author vscode
 */
public interface BankAccount {

  /**
   * Gets the account number.
   *
   * @return The account number.
   */
  String getAccountNumber();

  /**
   * Gets the owners of the account.
   *
   * @return The owners of the account.
   */
  Set<Customer> getOwners();

  /**
   * Deposits funds into the account.
   *
   * @param amount The amount to deposit.
   */
  void deposit(double amount) throws IllegalStateException;

  /**
   * Withdraws funds from the account.
   *
   * @param amount
   * @throws InsufficientFundsException
   */
  void withdraw(double amount) throws InsufficientFundsException;

  /**
   * Gets the balance of the account.
   *
   * @return The balance of the account.
   */
  double getBalance();

  /** Closes the account. */
  void closeAccount() throws IllegalStateException;

  /**
   * Checks if the account is closed.
   *
   * @return True if the account is closed, otherwise false.
   */
  boolean isClosed();
}
