package com.codedifferently.lesson7.MohamedObjects.Main;

import java.util.HashSet;
import java.util.Set;

enum empty {}

public class GPU extends Parts {

  Set<portTypes> ports = new HashSet<portTypes>();

  int vRam;

  boolean hasRayTracing;

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

  public Set<portTypes> getPorts() {
    return ports;
  }

  public void addPorts(portTypes port) {
    this.ports.add(port);
  }

  public int printNumPorts() {
    int i = 0;
    for (portTypes a : ports) {
      i++;
    }
    return i;
  }
}
