package com.codedifferently.lesson7.Jamiralesson7;

public class Laptops {

  // Enum
  public enum color {
    GREY,
    SILVER,
    BLACK,
    ORANGE,
    PINK,
    WHITE,
    RED,
    BLUE,
  }

  // variables
  public String Brand;
  public int Ports;
  public double Screensize;
  public String color;
  public int storageAmount;

  // constructor

  public Laptops(String brand, int ports, double screensize, int gigabyteamount) {
    this.Brand = brand;
    this.Ports = ports;
    this.Screensize = screensize;
    this.storageAmount = gigabyteamount;
  }

  // methods

  public void printBrand() {
    System.out.println("Brand: " + Brand);
  }

  public int availablePorts() {
    return Ports;
  }

  public int calculateTotalStorage(int[] gigaByteAmounts) {
    int totalStorage = 0;
    for (int storageAmount : gigaByteAmounts) {
      totalStorage += storageAmount;
    }
    return totalStorage;
  }

  public boolean validateBrand() {
    return Brand != null && !Brand.isEmpty();
  }

  // Exception
  class InvalidBrandException extends Exception {
    public InvalidBrandException(String message) {
      super(message);
    }
  }
}
