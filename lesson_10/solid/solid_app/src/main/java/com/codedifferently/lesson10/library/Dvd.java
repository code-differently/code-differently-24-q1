package com.codedifferently.lesson10.library;

public class Dvd extends Media {
  @Override
  public void checkOut(Patron borrower, Library library) throws MediaNotAvailableException {
    // Implement DVD checkout logic here
  }

  @Override
  public void checkIn(Patron borrower, Library library) {
    // Implement DVD checkin logic here
  }
}
