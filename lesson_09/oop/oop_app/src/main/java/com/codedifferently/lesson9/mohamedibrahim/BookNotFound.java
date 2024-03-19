package com.codedifferently.lesson9.mohamedibrahim;

public class BookNotFound extends RuntimeException {
  /**
   * @param error
   */
  BookNotFound(String error) {
    super(error);
  }
}
