package com.codedifferently.lesson7.mohamedobjects.main;

import java.util.HashSet;
import java.util.Set;

public class GPU extends Part {

  private Set<portType> ports = new HashSet<portType>();

  private int vRam;

  private boolean hasRayTracing;

  public GPU() {}

  public GPU(String name, int releaseYear, String brand, int vRam) {
    this.vRam = vRam;
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
  }

  public GPU(String name, int releaseYear, String brand, int vRam, boolean hasRayTracing) {
    this.vRam = vRam;
    this.name = name;
    checkValidYear(releaseYear);
    this.releaseYear = releaseYear;
    this.brand = brand;
  }

  public void setvRam(int vRam) {
    this.vRam = vRam;
  }

  public void setHasRayTracing(boolean hasRayTracing) {
    this.hasRayTracing = hasRayTracing;
  }

  public int getvRam() {
    return vRam;
  }

  public Set<portType> getPorts() {
    return ports;
  }

  public void addPorts(portType port) {
    this.ports.add(port);
  }

  public int calculateNumPorts() {
    // this was set to a loop to meet project reqirements
    return ports.size();
  }
}
