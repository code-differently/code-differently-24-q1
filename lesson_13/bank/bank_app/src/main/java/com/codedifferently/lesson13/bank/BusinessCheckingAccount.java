package com.codedifferently.lesson13.bank;

import java.util.Set;

import javax.naming.spi.DirStateFactory;

import com.codedifferently.lesson13.bank.exceptions.NoBusinessOwnersException;
import com.codedifferently.lesson13.bank.exceptions.InsufficientFundsException;

public class BusinessCheckingAccount extends CheckingAccount {
    
    public BusinessCheckingAccount(String accountNumber, Set<Customer> owners, double initialBalance) {
    super(accountNumber, owners, initialBalance);
    if (checkOwners(owners) == 0) {
      throw new NoBusinessOwnersException("A business owner must be one of the customers opening a business account.");
    }
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
        isActive = true;}
    private int checkOwners(Set<Customer> owners) {
        // Implement logic to check if any of the owners are business owners
        // Return the number of business owners found
        // Example:
        int businessOwnersCount = 0;
        for (Customer customer : owners) {
          if (customer.isCustomerBusiness()) { int result;
// Assuming isBusiness() method exists in Customer class
            result ++;
          }
        }
        return businessOwnersCount;


  }

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