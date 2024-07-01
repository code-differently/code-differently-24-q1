package com.codedifferently.lesson7.richhawkins;

import java.time.Year;

public class House {
  //     The class must have at least 5 member variables of at least 3 different types.
  private String streetName;
  private int streetNum;
  private int yearBuilt;
  private boolean hasGarage;
  private int numberOfBedrooms;

  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }

  public int getStreetNum() {
    return streetNum;
  }

  public void setStreetNum(int streetNum) {
    this.streetNum = streetNum;
  }

  public int getYearBuilt() {
    return yearBuilt;
  }

  public boolean getHasGarage() {
    return hasGarage;
  }

  public void setHasGarage(boolean hasGarage) {
    this.hasGarage = hasGarage;
  }

  public int getNumberOfBedrooms() {
    return numberOfBedrooms;
  }

  public void setNumberOfBedrooms(int numberOfBedrooms) {
    this.numberOfBedrooms = numberOfBedrooms;
  }

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
  private boolean checkValidYear() {
    int currentYear = Year.now().getValue();
    return yearBuilt <= currentYear;
  }

  public void setYearBuilt(int yearBuilt) {
    this.yearBuilt = yearBuilt;
    if (!checkValidYear()) {
      throw new InvalidYearException("Error: Must enter a valid year.");
    }
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
