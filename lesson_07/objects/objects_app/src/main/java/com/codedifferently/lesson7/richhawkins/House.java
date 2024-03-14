package com.codedifferently.lesson7.richhawkins;

import java.time.Year;

public class House {
  //     The class must have at least 5 member variables of at least 3 different types.
  String streetName;
  int streetNum;
  int yearBuilt;
  boolean hasGarage;
  short numberOfBedrooms;

  // You must also incorporate an enum type as well.

  public enum HouseType {
    APARTMENT,
    BUNGALOW,
    COTTAGE,
    CAPECOD,
    COLONIAL,
    FARMHOUSE,
    MANSION,
    TINYHOME,
    TOWNHOUSE,
    SINGLEFAMILY,
    SPLITLEVEL,
  }

  // The class must have at least one constructor.

  public House(String streetName, int streetNum) {
    this.streetName = streetName;
    this.streetNum = streetNum;
  }

  // The class must have at least 3 member functions.

  // One of your functions must make use of a conditional expression.
  // You must use at least one custom exception.
  public boolean checkValidYear(int yearBuilt) {
    int currentYear = Year.now().getValue();
    if (yearBuilt > currentYear) {
      throw new InvalidYearException("Year must be equal to or less than current year.");
    }
    return true;
  }

  public String printFullAddress() {
    String address = ("Your address is " + streetNum + " " + streetName);
    return address;
  }

  // One of your functions must make use of a loop.
  public String allHouseType() {
    StringBuilder types = new StringBuilder();
    for (HouseType type : HouseType.values()) {
      types.append(type).append(" ");
    }
    return types.toString();
  }
}
