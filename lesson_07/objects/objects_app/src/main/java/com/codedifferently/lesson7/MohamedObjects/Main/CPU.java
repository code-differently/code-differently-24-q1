package com.codedifferently.lesson7.mohamedobjects.main;

// CPU is a child class of Part this means that CPU inherits name, releaseYear, and brand
public class CPU extends Part {

  // initialization of member variables for CPU
  private double clockSpeed;
  private int cores;

  // A constructor that takes in brand.
  public CPU(cpuBrand brand) {
    this.brand = brand.toString();
  }

  // Constructor for GPU that needs name, releaseYear, brand, and clockSpeed
  public CPU(String name, int releaseYear, cpuBrand brand, double clockSpeed) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand.toString();
    this.clockSpeed = clockSpeed;
  }

  // Constructor for GPU that needs name, releaseYear, brand, clockSpeed, and cores
  public CPU(String name, int releaseYear, cpuBrand brand, double clockSpeed, int cores) {
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand.toString();
    this.clockSpeed = clockSpeed;
    this.cores = cores;
  }

  // Fuctions that set the value for all the member variables in CPU
  public void setClockSpeed(double clockSpeed) {
    this.clockSpeed = clockSpeed;
  }

  public void setCores(int cores) {
    this.cores = cores;
  }

  // Functions that retreve the member variables.
  public double getClockSpeed() {
    return clockSpeed;
  }

  public int getCores() {
    return cores;
  }

  // Calculates the performance for a CPU by clockSpeed to the power of the core count
  public double calcPerformance() {
    if (cores == 0 || clockSpeed == 0) {
      return 0;
    } else {
      double performance = clockSpeed;
      for (int i = 1; i < cores; i++) {
        performance *= clockSpeed;
      }
      return Math.round(performance);
    }
  }
}
