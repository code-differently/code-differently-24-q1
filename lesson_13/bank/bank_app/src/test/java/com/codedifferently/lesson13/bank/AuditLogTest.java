package com.codedifferently.lesson13.bank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class AuditLogTest {

  @Test
  void testLogTransaction() {
    // Given
    AuditLog auditLog = new AuditLog();
    String transaction = "Deposit $100";

    // When
    auditLog.logTransaction(transaction);
    List<String> transactions = auditLog.getTransactions();

    // Then
    assertTrue(transactions.contains(transaction));
  }

  @Test
  void testGetTransactions() {
    // Given
    AuditLog auditLog = new AuditLog();
    auditLog.logTransaction("Deposit $100");
    auditLog.logTransaction("Withdraw $50");

    // When
    List<String> transactions = auditLog.getTransactions();

    // Then
    assertEquals(2, transactions.size());
    assertTrue(transactions.contains("Deposit $100"));
    assertTrue(transactions.contains("Withdraw $50"));
  }
}
