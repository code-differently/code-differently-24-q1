package com.codedifferently.lesson13.bank.audit;
import java.util.Set;
import java.util.UUID;

import com.codedifferently.lesson13.bank.BankAccountBase;
import com.codedifferently.lesson13.bank.BankAtm;
import com.codedifferently.lesson13.bank.CheckingAccount;
import com.codedifferently.lesson13.bank.Customer;


public class AuditLog extends BankAtm {
  public AuditLog(String accountNumber, UUID customerId){
  }

  public record BankAccount(String accountNumber, UUID customerId){}
 static boolean checkingTransaction;

 public boolean isChecking () {
  return checkingTransaction; }

  public boolean isSavings () {
    return savingsTransaction; }
  
   }
 

  
  







 
    


