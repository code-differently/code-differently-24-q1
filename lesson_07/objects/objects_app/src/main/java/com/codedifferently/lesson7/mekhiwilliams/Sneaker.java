package com.codedifferently.lesson7.mekhiwilliams;

// Custom class representing a sneaker
public class Sneaker {
  // Enum for different sneaker types
  public enum SneakerType {
    RUNNING,
    BASKETBALL,
    CASUAL
  }

  // Member variables
  private String brand;
  private String model;
  private double size;
  private SneakerType type;
  private boolean isLimitedEdition;

  // Constructor
  public Sneaker(
      String brand, String model, double size, SneakerType type, boolean isLimitedEdition) {
    this.brand = brand;
    this.model = model;
    this.size = size;
    this.type = type;
    this.isLimitedEdition = isLimitedEdition;
  }

  // Getter methods
  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  public double getSize() {
    return size;
  }

  public SneakerType getType() {
    return type;
  }

  public boolean isLimitedEdition() {
    return isLimitedEdition;
  }

  // Function using conditional expression
  public String getPopularity() {
    return isLimitedEdition ? "Limited Edition" : "Regular Edition";
  }

  // Function using loop
  public void displaySneakerDetails() {
    System.out.println("Brand: " + brand);
    System.out.println("Model: " + model);
    System.out.println("Size: " + size);
    System.out.println("Type: " + type);
    System.out.println("Edition: " + getPopularity());
  }

  // Function throwing custom exception
  public void validateSize() throws InvalidSizeException {
    if (size <= 0) {
      throw new InvalidSizeException("Size should be greater than 0");
    }
  }

  // Custom exception class
  public static class InvalidSizeException extends Exception {
    public InvalidSizeException(String message) {
      super(message);
    }
  }
}
