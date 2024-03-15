package com.codedifferently.lesson7.jadatvapp;

import java.util.List;


public class Tv {
  private String brand;
  private String model;
  private double screenSize; // Renamed to follow naming convention
  private String resolution;
  private DisplayTechnology displaytechnology;
  private boolean isSmart;
  private List<String> inputports;

  public Tv(
      String brand,
      String model,
      double screenSize, // Renamed to follow naming convention
      String resolution,
      DisplayTechnology displayTechnology,
      boolean isSmart,
      List<String> inputports) {
    this.brand = brand;
    this.model = model;
    this.screenSize = screenSize; // Renamed to follow naming convention
    this.resolution = resolution;
    this.displaytechnology = displayTechnology;
    this.isSmart = isSmart;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) { // Renamed to follow naming convention
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public double getScreenSize() { // Renamed to follow naming convention
    return screenSize;
  }

  public void setScreenSize(double screenSize) { // Renamed to follow naming convention
    this.screenSize = screenSize;
  }

  public String getResolution() { // Renamed to follow naming convention
    StringBuilder modifiedResolution = new StringBuilder();
    for (int i = 0; i < resolution.length(); i++) {
      char c = resolution.charAt(i);

      if (Character.isLetter(c)) {
        modifiedResolution.append(Character.toUpperCase(c));
      } else {
        modifiedResolution.append(c);
      }
    }
    return modifiedResolution.toString();
  }

  public String hasSmartFeatures() {
    return isSmart ? "Yes" : "No";
  }

  public void throwCustomException() throws TVException {
    if (screenSize < 30) { // Renamed to follow naming convention
      throw new TVException(("Screen size is too small."));
    }
  }
}

