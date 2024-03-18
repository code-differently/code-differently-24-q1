package com.codedifferently.lesson7.Spaceship;

public class CommandCenter {

  public boolean firstEvent() {
    boolean eventStatus = true;

    Astronaut firstAstronaut = new Astronaut("Vicente", 21);
    Astronaut secondAstronaut = new Astronaut("Cristiano", 39);
    Astronaut thirdAstronaut = new Astronaut("Lionel", 36);

    Crew delawareCrew = new Crew();
    delawareCrew.addCrewMember(firstAstronaut);
    delawareCrew.addCrewMember(secondAstronaut);
    delawareCrew.addCrewMember(thirdAstronaut);

    System.out.println("First event started with crew: " + delawareCrew + " ship is getting ready");

    int numberOfSpaceshipsToBeSent = 5;

    for (int spaceshipCount = 0; spaceshipCount <= numberOfSpaceshipsToBeSent; spaceshipCount++) {
      Spaceship delawareShip = new Spaceship();
      delawareShip.setSpaceshipName("Apollo" + spaceshipCount);
      delawareShip.setCrew(delawareCrew);

      try {
        System.out.println(
            delawareShip.getSpaceshipName() + " status: " + delawareShip.getStatus());
        delawareShip.Launch();
        System.out.println(
            delawareShip.getSpaceshipName() + " status: " + delawareShip.getStatus());
        delawareShip.Landed();
        System.out.println(
            delawareShip.getSpaceshipName() + " status: " + delawareShip.getStatus());
      } catch (Exception e) {
        System.out.println(e.getMessage());
        eventStatus = false;
      }
    }
    return eventStatus;
  }

  public boolean secondEvent() {
    boolean eventStatus = true;
    Astronaut firstAstronaut = new Astronaut("Vicente", 21);

    Crew delawareCrew = new Crew();
    delawareCrew.addCrewMember(firstAstronaut);
    System.out.println("Second event started with crew: " + delawareCrew);

    int numberOfSpaceshipsToBeSent = 5;

    for (int spaceshipCount = 0; spaceshipCount <= numberOfSpaceshipsToBeSent; spaceshipCount++) {
      Spaceship delawareShip = new Spaceship();
      delawareShip.setSpaceshipName("Apollo" + spaceshipCount);
      delawareShip.setCrew(delawareCrew);

      try {
        delawareShip.Launch();
        delawareShip.Landed();
      } catch (Exception e) {
        System.out.println(e.getMessage());
        eventStatus = false;
      }

      System.out.println("current status: " + delawareShip);
    }
    return eventStatus;
  }
}
