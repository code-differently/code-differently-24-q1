package com.codedifferently.lesson10.library.exceptions;

public class ItemCantBeCheckOutException extends RuntimeException {
  public ItemCantBeCheckOutException(String error) {
    super(error);
  }
}
