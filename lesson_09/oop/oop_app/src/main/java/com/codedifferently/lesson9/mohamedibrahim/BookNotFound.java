package com.codedifferently.lesson9.mohamedibrahim;

public class BookNotFound extends RuntimeException {
  BookNotFound(String error) {
    super(error);
  }
}
