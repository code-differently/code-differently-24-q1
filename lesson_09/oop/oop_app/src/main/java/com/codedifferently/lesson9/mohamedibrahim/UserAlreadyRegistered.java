package com.codedifferently.lesson9.mohamedibrahim;

public class UserAlreadyRegistered extends RuntimeException {
  UserAlreadyRegistered(String error) {
    super(error);
  }
}
