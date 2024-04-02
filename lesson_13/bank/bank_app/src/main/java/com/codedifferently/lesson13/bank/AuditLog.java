package com.codedifferently.lesson13.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AuditLog {

  Map<String, List<String>> logsByAccountNum = new HashMap<>();

  public void document(BankAccount account, String action) {
    if (!logsByAccountNum.containsKey(account.getAccountNumber())) {
      logsByAccountNum.put(account.getAccountNumber(), new ArrayList<>());
    }
    logsByAccountNum.get(account.getAccountNumber()).add(action);
  }

  public Map<String, List<String>> getLogsByAccountNum() {
    return logsByAccountNum;
  }

  public List<String> getLogsForAccount(BankAccount account) {
    return logsByAccountNum.get(account.getAccountNumber());
  }
}
