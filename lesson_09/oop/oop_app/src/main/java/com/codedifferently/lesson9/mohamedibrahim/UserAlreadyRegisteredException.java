package com.codedifferently.lesson9.mohamedibrahim;

public class UserAlreadyRegisteredException extends RuntimeException {
  UserAlreadyRegisteredException(String error) {
    super(error);
  }
}
