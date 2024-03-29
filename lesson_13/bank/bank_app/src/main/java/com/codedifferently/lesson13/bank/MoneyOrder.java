package com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.IsVoidedException;
/**
 * Represents a money order.
 * 
 * @author mohamedibrahim
 */
public class MoneyOrder {

  private String orderNumber;
  private double amount;
  private BankAccountBase account;
  private boolean isVoided = false;


    /**
     * Creates a money order. 
     * 
     * @param orderNumber Order number for the money order
     * @param amount Amount the money oorder is taken out for.
     * @param account The account the money is coming from. 
     */
  public MoneyOrder(String orderNumber, double amount, BankAccountBase account) {
    this.orderNumber = orderNumber;
    if (amount > 1000.0 || amount <= 0.0) {
      throw new IllegalArgumentException(
          "This Amount is greater than 1000$ or less than or equal to 0$.");
    }
    account.withdraw(amount);
    if (amount > 500.0) this.amount = amount - 3.00;
    else this.amount = amount - 2.10;
    this.account = account;
  }

  /**
   * Gets the voided status of the money order.
   *
   * @return True if the money order is voided, and false otherwise.
   */
  public boolean getIsVoided() {
    return isVoided;
  }

  /** Voids the check. */
  public void voidOrder() {
    isVoided = true;
  }

  /**
   * Deposits the money order into an account.
   *
   * @param toAccount The account to deposit the money order into.
   */
  public void depositFunds(BankAccount toAccount) {
    if (isVoided) {
      throw new IsVoidedException("Order is voided");
    }
    toAccount.deposit(amount);
    voidOrder();
  }

  @Override
  public int hashCode() {
    return orderNumber.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MoneyOrder other) {
      return orderNumber.equals(other.orderNumber);
    }
    return false;
  }

  @Override
  public String toString() {
    return "MoneyOrder{"
        + "orderNumber='"
        + orderNumber
        + '\''
        + ", amount="
        + amount
        + ", account="
        + account.getAccountNumber()
        + '}';
  }
}
