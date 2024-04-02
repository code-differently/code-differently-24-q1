package com.codedifferently.lesson13.bank;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.lesson13.bank.exceptions.IsVoidedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyOrderTest {

  private BankAccount account1;
  private BankAccount account2;
  private MoneyOrder classUnderTest;

  @BeforeEach
  void setUp() {
    account1 = new CheckingAccount("123456789", null, 100.0);
    account2 = new CheckingAccount("987654321", null, 200.0);
    classUnderTest = new MoneyOrder("123456789", 50.0, account1);
  }

  @Test
  void testIllegalArgumentException_ForOver1000() throws IllegalArgumentException {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new MoneyOrder("1234323423", 1001, account1))
        .withMessage("This Amount is greater than 1000$ or less than or equal to 0$.");
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new MoneyOrder("12343234", -1, account1))
        .withMessage("This Amount is greater than 1000$ or less than or equal to 0$.");
  }

  @Test
  void testWithdrawal_OnCreation() {
    assertEquals(50, account1.getBalance());
  }

  @Test
  void testMoneyOrderDeposit() {
    classUnderTest.depositFunds(account2);

    assertEquals(250.0 - 2.10, account2.getBalance());
  }

  @Test
  void testDepositFunds_OrderVoided() throws IsVoidedException {
    // Arrange
    classUnderTest.voidOrder();

    // Act & Assert
    assertThatExceptionOfType(IsVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds(account2))
        .withMessage("Order is voided");
  }
}
