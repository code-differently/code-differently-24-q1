package com.codedifferently.lesson9.mohamedibrahim;

public class BookNotFoundException extends RuntimeException {
  /**
   * @param error
   */
  BookNotFoundException(String error) {
    super(error);
  }
}
