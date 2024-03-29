package com.codedifferently.lesson13.bank;

public interface FinancialInstrument {
    void depositFunds(BankAccount account, double amount);
    double withdrawFunds();
}
