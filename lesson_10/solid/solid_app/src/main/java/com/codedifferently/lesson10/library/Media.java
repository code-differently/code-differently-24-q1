package com.codedifferently.lesson10.library;

public abstract class Media {
  public abstract void checkOut(Patron borrower, Library library) throws MediaNotAvailableException;

  public abstract void checkIn(Patron borrower, Library library);
}
