package main.java.com.codedifferently.lesson9.richhawkins;

public class AlreadyCheckedOutException extends RuntimeException {
  public AlreadyCheckedOutException(String message) {
    super(message);
  }
}
