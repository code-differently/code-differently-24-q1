package com.codedifferently.lesson7.natayaprice;

public class Phone {

  public enum Color {
    BLUE,
    GREEN,
    PINK,
    BLACK,
    WHITE,
    YELLOW;
  }

  private Color color;
  private String serviceProvider;
  private int storageCapacity;
  private double price;
  private String brand;

  public Phone(
      Color color, double price, String brand, String serviceProvider, int storageCapacity) {
    this.color = color;
    this.price = price;
    this.brand = brand;
    this.serviceProvider = serviceProvider;
    this.storageCapacity = storageCapacity;
  }

  public void listColor() {
    for (int i = 0; i < Color.values().length; i++) {
      Color color = Color.values()[i];
      System.out.println(color);
    }
  }

  public Object getColor() {
    return color;
  }

  public static void comparePrice(int price1, int price2) {
    int difference = price1 - price2;
    System.out.println("The difference between " + price1 + " && " + price2 + " is: " + difference);
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) throws InvalidPriceException {
    if (price < 0) {
      throw new InvalidPriceException("Price cannot be negative.");
    }
    this.price = price;
  }

  public class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
      super(message);
    }
  }

  public int getStorageCapacity() {
    return storageCapacity;
  }

  public String getServiceProvider() {
    return serviceProvider;
  }

  public String getBrand() {
    return brand;
  }
}
