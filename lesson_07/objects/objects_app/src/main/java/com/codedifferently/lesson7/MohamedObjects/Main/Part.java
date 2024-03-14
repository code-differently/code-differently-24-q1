package com.codedifferently.lesson7.mohamedobjects.main;

public class Part {
  String name;
  int releaseYear;
  String brand;

  public Part() {}

  public Part(String name, int releaseYear, String brand) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
  }

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

  public String getBrand() {
    return brand;
  }

  public String getName() {
    return name;
  }

  public int getReleaseYear() {
    return releaseYear;
  }

  public boolean checkValidYear(int year) {
    if (year <= 2024 && year >= 2000) {
      return true;
    } else {
      throw new IllegalYearExeption("Year is out of expected range. 2000 - 2024");
    }
  }
}
