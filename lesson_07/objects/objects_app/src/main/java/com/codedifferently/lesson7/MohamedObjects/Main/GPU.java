package com.codedifferently.lesson7.mohamedobjects.main;

import java.util.HashSet;
import java.util.Set;

// GPU is a child class of Part this means that GPU inherits name, releaseYear, and brand
public class GPU extends Part {

  // initialization of member variables for GPU
  private Set<portType> ports = new HashSet<portType>();
  private int vRam;
  private boolean hasRayTracing;

  // empty constructor for GPU
  public GPU() {}

  // Constructor for GPU that needs name, releaseYear, brand, and vRam
  public GPU(String name, int releaseYear, String brand, int vRam) {
    this.vRam = vRam;
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
  }

  // Constructor for GPU that needs name, releaseYear, brand, vRam, and hasRayTracing
  public GPU(String name, int releaseYear, String brand, int vRam, boolean hasRayTracing) {
    this.vRam = vRam;
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
    this.hasRayTracing = hasRayTracing;
  }

  // Fuctions that set the value for all the member variables in GPU
  public void setvRam(int vRam) {
    this.vRam = vRam;
  }

  public void setHasRayTracing(boolean hasRayTracing) {
    this.hasRayTracing = hasRayTracing;
  }

  // Functions that retreve the member variables.
  public int getvRam() {
    return vRam;
  }

  public boolean getHasRayTracing() {
    return hasRayTracing;
  }

  public Set<portType> getPorts() {
    return ports;
  }

  // Adds ports to a set that contains ports
  public void addPorts(portType port) {
    this.ports.add(port);
  }

  // A function that returns number of ports
  public int calculateNumPorts() {
    return ports.size();
  }
}
