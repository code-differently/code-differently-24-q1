import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import com.codedifferently.lesson13.bank.exceptions.AccountNotFoundException;
import com.codedifferently.lesson13.bank.exceptions.CheckVoidedException;
import com.codedifferently.lesson13.bank.exceptions.IsVoidedException;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;

class BankAtmTest {

  private BankAtm classUnderTest;
  private CheckingAccount account1;
  private CheckingAccount account2;
  private BankAccount account1;
  private BankAccount account2;
  private Customer customer1;
  private Customer customer2;

  @BeforeEach
  void setUp() {
    classUnderTest = new BankAtm();
    customer1 = new Customer(UUID.randomUUID(), "John Doe");
    customer1 = new Customer(UUID.randomUUID(), "John Doe", true);
    customer2 = new Customer(UUID.randomUUID(), "Jane Smith");
    account1 = new CheckingAccount("123456789", Set.of(customer1), 100.0);
    account1 = new BusinessCheckingAccount("123456789", Set.of(customer1), 100.0);
    account2 = new CheckingAccount("987654321", Set.of(customer1, customer2), 200.0);
    customer1.addAccount(account1);
    customer1.addAccount(account2);
 void setUp() {
  void testAddAccount() {
    // Arrange
    Customer customer3 = new Customer(UUID.randomUUID(), "Alice Johnson");
    CheckingAccount account3 = new CheckingAccount("555555555", Set.of(customer3), 300.0);
    BankAccount account3 = new SavingsAccount("555555555", Set.of(customer3), 300.0);
    customer3.addAccount(account3);

    // Act
    classUnderTest.addAccount(account3);

    // Assert
    Set<CheckingAccount> accounts = classUnderTest.findAccountsByCustomerId(customer3.getId());
    Set<BankAccount> accounts = classUnderTest.findAccountsByCustomerId(customer3.getId());
    assertThat(accounts).containsOnly(account3);
  }

  @Test
  void testFindAccountsByCustomerId() {
    // Act
    Set<CheckingAccount> accounts = classUnderTest.findAccountsByCustomerId(customer1.getId());
    Set<BankAccount> accounts = classUnderTest.findAccountsByCustomerId(customer1.getId());

    // Assert
    assertThat(accounts).containsOnly(account1, account2);
 void testDepositFunds() {
  @Test
  void testDepositFunds_Check() {
    // Arrange
    Check check = new Check("987654321", 100.0, account1);
    Check check = new Check("987654321", 100.0, (CheckingAccount) account1);

    // Act
    classUnderTest.depositFunds("987654321", check);
 void testDepositFunds_Check() {

  @Test
  void testDepositFunds_DoesntDepositCheckTwice() {
    Check check = new Check("987654321", 100.0, account1);
    var check = new Check("987654321", 100.0, (CheckingAccount) account1);

    classUnderTest.depositFunds("987654321", check);

    assertThatExceptionOfType(CheckVoidedException.class)
    assertThatExceptionOfType(IsVoidedException.class)
        .isThrownBy(() -> classUnderTest.depositFunds("987654321", check))
        .withMessage("Check is voided");
  }
 void testWithdrawFunds_AccountNotFound() {
        .isThrownBy(() -> classUnderTest.withdrawFunds(nonExistingAccountNumber, 50.0))
        .withMessage("Account not found");
  }

  @Test
  void testAuditLog() {
    assertThat(classUnderTest.atmLog.getLogsByAccountNum().containsKey(account1.accountNumber));
    assertThat(classUnderTest.atmLog.getLogsByAccountNum().containsKey(account2.accountNumber));
    assertThat(
        classUnderTest
            .atmLog
            .getLogsByAccountNum()
            .get(account1.accountNumber)
            .contains("Added Account to BankAtm."));
    assertThat(
        classUnderTest
            .atmLog
            .getLogsByAccountNum()
            .get(account2.accountNumber)
            .contains("Added Account to BankAtm."));
  }
}