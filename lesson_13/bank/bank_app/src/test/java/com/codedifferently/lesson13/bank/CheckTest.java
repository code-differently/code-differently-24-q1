package com.codedifferently.lesson13.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson13.bank.exceptions.CheckVoidedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CheckTest {

  private CheckingAccount account1;
  private CheckingAccount account2;
  private Check check;

  @BeforeEach
  void setUp() {
    account1 = new CheckingAccount("123456789", null, 100.0);
    account2 = new CheckingAccount("987654321", null, 200.0);
    check = new Check("123456789", 50.0, account1);
  }

  @Test
  void testDepositFunds() {
    // Act
    check.depositFunds(account2);

    // Assert
    assertThat(account1.getBalance()).isEqualTo(50.0);
    assertThat(account2.getBalance()).isEqualTo(250.0);
  }

  @Test
  void testDepositFunds_CheckVoided() {
    // Arrange
    check.voidCheck();

    // Act & Assert
    assertThatExceptionOfType(CheckVoidedException.class)
        .isThrownBy(() -> check.depositFunds(account2))
        .withMessage("Check is voided");
  }

  @Test
  void testConstructor_CantCreateCheckWithNegativeAmount() {
    // Act & Assert
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Check("123456789", -50.0, account1))
        .withMessage("Check amount must be positive");
  }

  @Test
  void testHashCode() {
    // Arrange
    Check otherCheck = new Check("123456789", 100.0, account1);

    // Assert
    assertThat(check.hashCode()).isEqualTo(otherCheck.hashCode());
  }

  @Test
  void testEquals() {
    // Arrange
    Check otherCheck = new Check("123456789", 100.0, account1);
    Check differentCheck = new Check("987654321", 100.0, account1);

    // Assert
    assertThat(check.equals(otherCheck)).isTrue();
    assertThat(check.equals(differentCheck)).isFalse();
  }

  @Test
  void testToString() {
    // Assert
    assertThat(check.toString())
        .isEqualTo("Check{checkNumber='123456789', amount=50.0, account=123456789}");
  }
}
