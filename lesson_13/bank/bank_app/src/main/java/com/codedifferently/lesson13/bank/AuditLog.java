package com.codedifferently.lesson13.bank;

import java.util.ArrayList;
import java.util.List;

/** Represents an audit log for bank transactions. */
public class AuditLog {
  private final List<String> transactions;

  /** Creates a new audit log. */
  public AuditLog() {
    this.transactions = new ArrayList<>();
  }

  /**
   * Logs a transaction.
   *
   * @param transaction The transaction to log.
   */
  public void logTransaction(String transaction) {
    transactions.add(transaction);
  }

  /**
   * Gets the transactions in the audit log.
   *
   * @return The transactions in the audit log.
   */
  public List<String> getTransactions() {
    return transactions;
  }
}
