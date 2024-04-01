/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.codedifferently.lesson13.bank;

import java.util.Set;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;

/**
 *
 * @author vscode
 */
public class BankAccountBase {

    protected final Set<Customer> owners;
    protected final String accountNumber;
    protected double balance;
    protected boolean isActive;

    public BankAccountBase() {
    }

    /**
     * Gets the account number.
     *
     * @return The account number.
     */
    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Gets the owners of the account.
     *
     * @return The owners of the account.
     */
    @Override
    public Set<Customer> getOwners() {
        return owners;
    }

    /**
     * Deposits funds into the account.
     *
     * @param amount The amount to deposit.
     */
    @Override
    public void deposit(double amount) throws IllegalStateException {
        if (isClosed()) {
            throw new IllegalStateException("Cannot deposit to a closed account");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    /**
     * Withdraws funds from the account.
     *
     * @param amount
     * @throws InsufficientFundsException
     */
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (isClosed()) {
            throw new IllegalStateException("Cannot withdraw from a closed account");
        }
        if (amount <= 0) {
            throw new IllegalStateException("Withdrawal amount must be positive");
        }
        if (balance < amount) {
            throw new InsufficientFundsException("Account does not have enough funds for withdrawal");
        }
        balance -= amount;
    }

    /**
     * Gets the balance of the account.
     *
     * @return The balance of the account.
     */
    @Override
    public double getBalance() {
        return balance;
    }

    /** Closes the account. */
    @Override
    public void closeAccount() throws IllegalStateException {
        if (balance > 0) {
            throw new IllegalStateException("Cannot close account with a positive balance");
        }
        isActive = false;
    }

    /**
     * Checks if the account is closed.
     *
     * @return True if the account is closed, otherwise false.
     */
    @Override
    public boolean isClosed() {
        return !isActive;
    }

}
