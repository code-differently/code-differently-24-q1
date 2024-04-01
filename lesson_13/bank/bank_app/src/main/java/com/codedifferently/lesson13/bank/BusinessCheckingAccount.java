package com.codedifferently.lesson13.bank;

import java.util.UUID;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson13.bank.BankAccount;

public class BusinessCheckingAccount extends Customer {

  public BusinessCheckingAccount(UUID id, String name, boolean isBusinessAccount) {
    super(id, name); }



  public boolean isBusinessCheckingAccount(BankAccount bankaccount) throws AccountNotFoundException {
    if (!addAccount(bankAccount)) { 
        throw new AccountNotFoundException("Account is not business: " + bankAccount.getId());
    }
    return BankAccount.isBusinessAccount(bankAccount);

}
@Override
public String toString() {
  return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
}

}
