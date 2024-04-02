package main.java.com.codedifferently.lesson13.bank;

import com.codedifferently.lesson13.bank.exceptions.NoBusinessOwnersException;
import java.util.Set;

/** Represents a checking account. */
public class BusinessCheckingAccount extends CheckingAccount {

  /**
   * Creates a new business checking account.
   *
   * @param accountNumber The account number.
   * @param owners The owners of the account.
   * @param initialBalance The initial balance of the account.
   */
  public BusinessCheckingAccount(
      String accountNumber, Set<Customer> owners, double initialBalance) {
    super();
    if (checkOwners(owners) == 0) {
      throw new NoBusinessOwnersException(
          "A business owner must be one of the customers opening a business account.");
    }
    this.accountNumber = accountNumber;
    this.owners = owners;
    this.balance = initialBalance;
    isActive = true;
  }

  /**
   * Runs through the list of account holders and retruns the amount of business owners.
   *
   * @param holders
   * @return
   */
  private int checkOwners(Set<Customer> holders) {
    int result = 0;
    for (Customer customer : holders) {
      if (customer.isCustomerABusiness()) {
        result++;
      }
    }
    return result;
  }

  @Override
  public int hashCode() {
    return accountNumber.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof BusinessCheckingAccount other) {
      return accountNumber.equals(other.accountNumber);
    }
    return false;
  }

  @Override
  public String toString() {
    return "BusinessCheckingAccount{"
        + "accountNumber='"
        + accountNumber
        + '\''
        + ", balance="
        + balance
        + ", isActive="
        + isActive
        + '}';
  }
}