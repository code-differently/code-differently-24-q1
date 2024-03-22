package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.NoCheckoutException;

public class Newspaper implements Assets {
  @Override
  public void canOrCantCheckOut() {
    throw new NoCheckoutException("This item cannot be checked out.");
  }
}
