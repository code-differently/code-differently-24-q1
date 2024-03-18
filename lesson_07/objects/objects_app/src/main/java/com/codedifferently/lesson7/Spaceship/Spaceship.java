package com.codedifferently.lesson7.Spaceship;

public class Spaceship {

  private String spaceshipName;
  private String status = "parked"; // start with a parked status
  private Crew crew; // creates empty crew

  public void Launch() throws CrewSizeException {
    if (crew.getAstronautList().size() >= 2 && crew.getAstronautList().size() <= 4) {
      status = "launched";
    } else {
      throw new CrewSizeException(" cannot be launched because needs a proper crew size");
    }
  }

  public void Landed() {
    status = "Landed";
  }

  public String getStatus() {
    return status;
  }

  public void setCrew(Crew newCrew) {
    crew = newCrew;
  }

  public Crew getCrew() {
    return crew;
  }

  public String getSpaceshipName() {
    return spaceshipName;
  }

  public void setSpaceshipName(String spaceshipName) {
    this.spaceshipName = spaceshipName;
  }

  @Override
  public String toString() {
    return "Spaceship [spaceshipName="
        + spaceshipName
        + ", status="
        + status
        + ", crew="
        + crew
        + "]";
  }
}
