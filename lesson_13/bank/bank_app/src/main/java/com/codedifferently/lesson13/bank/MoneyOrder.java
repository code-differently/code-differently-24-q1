package com.codedifferently.lesson13.bank;

public class MoneyOrder implements FinancialInstrument {
    private double amount;

    // Constructor to initialize the amount field
    public MoneyOrder(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void depositFunds(BankAccount account, double amount) {
        account.deposit(amount);
    }

    @Override
    public double withdrawFunds() {
        // Implementation of withdrawFunds for MoneyOrder
        return 0;
        // Implementation of withdrawFunds for MoneyOrder
    }
}
