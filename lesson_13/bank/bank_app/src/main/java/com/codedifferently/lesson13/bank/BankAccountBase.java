package com.codedifferently.lesson13.bank;

import java.util.Set;

import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;



public class BankAccountBase implements BankAccounts{

protected final Set<Customer> owners;
protected final String accountNumber;
protected double balance;
protected boolean isActive;

public BankAccountBase((String accountNumber, Set<Customer> owners, double initialBalance)) {
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    isActive = true;
}

@Override
public String getAccountNumber(){
    return accountNumber;
}

@Override
public Set<Customer>getOwners(){
    return owners;
}


}
