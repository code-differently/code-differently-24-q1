package com.codedifferently.lesson7.ChukwumaIbezimTest;
 
import com.codedifferently.lesson7.chukwumaibezim.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("Jermaine Cole", 100.0, "2024-03-03", "CHECKING", 1843456889);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawSufficientFunds() {
        BankAccount account = new BankAccount("Michael B. Jordan", 200.0, "2022-11-19", "SAVINGS", 987654321);
        try {
            account.withdraw(100.0);
            assertEquals(100.0, account.getBalance(), 0.0);
        } catch (BankAccount.InsufficientFundsException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        BankAccount account = new BankAccount("Denzel Washington", 50.0, "2019-07-01", "CD", 135792468);
        try {
            account.withdraw(100.0);
            fail("Expected InsufficientFundsException was not thrown");
        } catch (BankAccount.InsufficientFundsException e) {
            assertEquals("Insufficient funds to withdraw $100.0", e.getMessage());
        }
    }

    @Test
    public void testTransferSufficientFunds() {
        BankAccount sourceAccount = new BankAccount("Jermaine Cole", 200.0, "2024-03-03", "CHECKING", 1843456889);
        BankAccount targetAccount = new BankAccount("Michael B. Jordan", 100.0, "2022-11-19", "SAVINGS", 987654321);
        try {
            sourceAccount.transfer(50.0, targetAccount);
            assertEquals(150.0, sourceAccount.getBalance(), 0.0);
            assertEquals(150.0, targetAccount.getBalance(), 0.0);
        } catch (BankAccount.InsufficientFundsException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    @Test
    public void testTransferInsufficientFunds() {
        BankAccount sourceAccount = new BankAccount("Jermaine Cole", 50.0, "2024-03-03", "CHECKING", 1843456889);
        BankAccount targetAccount = new BankAccount("Michael B. Jordan", 100.0, "2022-11-19", "SAVINGS", 987654321);
        try {
            sourceAccount.transfer(100.0, targetAccount);
            fail("Expected InsufficientFundsException was not thrown");
        } catch (BankAccount.InsufficientFundsException e) {
            assertEquals("Insufficient funds to transfer $100.0", e.getMessage());
        }
    }

    @Test
    public void testAddAdditionalInfo() {
        BankAccount account = new BankAccount("Jermaine Cole", 100.0, "2024-03-03", "CHECKING", 1843456889);
        account.addAdditionalInfo(1, "Transaction history");
        assertEquals("Transaction history", account.getAdditionalInfo(1));
    }

    @Test
    public void testRemoveAdditionalInfo() {
        BankAccount account = new BankAccount("Jermaine Cole", 100.0, "2024-03-03", "CHECKING", 1843456889);
        account.addAdditionalInfo(1, "Transaction history");
        account.removeAdditionalInfo(1);
        assertNull(account.getAdditionalInfo(1));
    }
}

