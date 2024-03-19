package com.codedifferently.lesson7.Spaceship;

import java.util.ArrayList;
import java.util.List;

public class Crew {

  List<Astronaut> astronautList = new ArrayList<Astronaut>();

  private final Integer MIN = 2;
  private final Integer MAX = 4;

  public Integer getMin() {
    return MIN;
  }

  public Integer getMax() {
    return MAX;
  }

  public void addCrewMember(Astronaut astronaut) {
    astronautList.add(astronaut);
  }

  public void removeCrewMember(Astronaut astronaut) {
    astronautList.remove(astronaut);
  }

  public List<Astronaut> getAstronautList() {
    return astronautList;
  }

  @Override
  public String toString() {
    return "Crew [astronautList=" + astronautList + ", MIN=" + MIN + ", MAX=" + MAX + "]";
  }
}
