package com.codedifferently.lesson13.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class AuditLog {

  Map<String, List<String>> logsByAccountNum = new HashMap<>();


  public void document(BankAccountBase account, String action) {
    if (!logsByAccountNum.containsKey(account.accountNumber)) {
      logsByAccountNum.put(account.accountNumber, new ArrayList<>());
    }
    logsByAccountNum.get(account.accountNumber).add(action);
  }
  public Map<String, List<String>> getLogsByAccountNum() {
    return logsByAccountNum;
  }

  public List<String> getLogsForAccount(BankAccountBase account) {
    return logsByAccountNum.get(account.accountNumber);
  }
}
