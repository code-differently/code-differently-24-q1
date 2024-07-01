package com.codedifferently.lesson7.mohamedobjects.main;

public class Part {
  // initialization of member variables for part
  String name;
  int releaseYear;
  String brand;

  // empty constructor for Part
  public Part() {}

  // constructor for Part that requires name, realeaseYear, and brand
  public Part(String name, int releaseYear, String brand) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
  }

  // Fuctions that set the value for all the member variables in Part
  public void setBrand(String brand) {
    this.brand = brand;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setReleaseYear(int releaseYear) {
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
  }

  // Functions that retreve the member variables.
  public String getBrand() {
    return brand;
  }

  public String getName() {
    return name;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  // A function that checks if the releaseYear is valid
  public boolean checkValidYear() {
    if (releaseYear <= 2024 && releaseYear >= 2000) {
      return true;
    } else {
      throw new IllegalYearExeption("Year is out of expected range. 2000 - 2024");
    }
  }

  // a function to check if a year was to be entered, is it valid
  public boolean checkValidYear(int year) {
    if (year <= 2024 && year >= 2000) {
      return true;
    } else {
      throw new IllegalYearExeption("Year is out of expected range. 2000 - 2024");
    }
  }
}
