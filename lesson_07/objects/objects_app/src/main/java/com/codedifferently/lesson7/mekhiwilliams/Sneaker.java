package com.codedifferently.lesson7.mekhiwilliams;

import java.util.ArrayList;
import java.util.List;

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

  // Valid sizes collection
  private static final List<Double> validSizes = new ArrayList<>();

  static {
    validSizes.add(7.0);
    validSizes.add(8.0);
    validSizes.add(9.0);
    validSizes.add(10.0);
    validSizes.add(11.0);
  }

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
    if (!validSizes.contains(size)) {
      throw new InvalidSizeException("Size is not valid");
    }
  }

  // Custom exception class
  public static class InvalidSizeException extends Exception {
    public InvalidSizeException(String message) {
      super(message);
    }
  }
}

