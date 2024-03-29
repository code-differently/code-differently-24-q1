package com.codedifferently.lesson13.bank;

import java.util.Set;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;

public class BusinessCheckingAccount implements BankAccounts {

@Override
public boolean isClosed() {
    return false; 
}

    @Override
    public String getAccountNumber() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Set<Customer> getOwners() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deposit(double amount) throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double getBalance() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void closeAccount() throws IllegalStateException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}