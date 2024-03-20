package com.codedifferently.lesson9.mohamedibrahim;

public class UserNotRegisteredException extends RuntimeException {
  UserNotRegisteredException(String error) {
    super(error);
  }
}
