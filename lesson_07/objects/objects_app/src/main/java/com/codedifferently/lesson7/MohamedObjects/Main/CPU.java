package com.codedifferently.lesson7.mohamedobjects.main;

public class CPU extends Part {
  double clockSpeed;
  int cores;

  public CPU(cpuBrand brand) {
    this.brand = brand.toString();
  }

  public CPU(String name, int releaseYear, cpuBrand brand, double clockSpeed) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand.toString();
    this.clockSpeed = clockSpeed;
  }

  public CPU(String name, int releaseYear, cpuBrand brand, double clockSpeed, int cores) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand.toString();
    this.clockSpeed = clockSpeed;
    this.cores = cores;
  }

  public void setClockSpeed(double clockSpeed) {
    this.clockSpeed = clockSpeed;
  }

  public double getClockSpeed() {
    return clockSpeed;
  }

  public void setCores(int cores) {
    this.cores = cores;
  }

  public int getCores() {
    return cores;
  }
}
