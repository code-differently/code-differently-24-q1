package com.codedifferently.lesson10.library;

public class Magazine extends Media {
  @Override
  public void checkOut(Patron borrower, Library library) throws MediaNotAvailableException {
    // Implement magazine checkout logic here
  }

  @Override
  public void checkIn(Patron borrower, Library library) {
    // Implement magazine checkin logic here
  }
}
