package com.codedifferently.lesson13.bank;

import java.util.ArrayList;
import java.util.List;

/** Represents an audit log for tracking transactions. */
public class AuditLog {
  private List<String> transactions;

  public AuditLog() {
    this.transactions = new ArrayList<>();
  }

  public void logTransaction(String accountNumber, double amount, String transactionType) {
    String logEntry = String.format("%s: %s $%.2f", transactionType, accountNumber, amount);
    transactions.add(logEntry);
    System.out.println("Transaction logged: " + logEntry);
  }
}
