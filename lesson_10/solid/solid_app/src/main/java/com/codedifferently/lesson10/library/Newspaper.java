package com.codedifferently.lesson10.library;

public class Newspaper extends Media {
  @Override
  public void checkOut(Patron borrower, Library library) throws MediaNotAvailableException {
    // Implement newspaper checkout logic here
  }

  @Override
  public void checkIn(Patron borrower, Library library) {
    // Implement newspaper checkin logic here
  }
}
