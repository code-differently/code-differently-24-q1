package com.codedifferently.lesson13.bank;

/** Represents a money order. */
public class MoneyOrder {
  private final double amount;

  /** money order amount must be positive */
  public MoneyOrder(double amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Money order amount must be positive");
    }
    this.amount = amount;
  }

  /**
   * Gets the amount of the money order.
   *
   * @return The amount of the money order.
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Deposits the money order into an account.
   *
   * @param toAccount The account to deposit the money order into.
   */
  public void depositFunds(CheckingAccount toAccount) {
    toAccount.withdraw(amount);
  }
}
