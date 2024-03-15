package com.codedifferently.lesson7.Spaceship;

public class CommandCenter {

    public boolean firstEvent() {
        Astronaut firstAstronaut = new Astronaut("Vicente",21);
        Astronaut secondAstronaut = new Astronaut("Michael",30);
        Astronaut thirdAstronaut = new Astronaut("Lionel",35);

        Crew delawareCrew = new Crew();
        delawareCrew.addCrewMember(firstAstronaut);
        delawareCrew.addCrewMember(secondAstronaut);
        delawareCrew.addCrewMember(thirdAstronaut);
        
        System.out.println("Event started with crew: " + delawareCrew);

        int numberOfSpaceshipsToBeSent = 5;

        for(int spaceshipCount = 0; spaceshipCount <= numberOfSpaceshipsToBeSent; spaceshipCount++) {
            Spaceship delawareShip = new Spaceship();
            delawareShip.setSpaceshipName("Apollo" + spaceshipCount);
            delawareShip.setCrew(delawareCrew);
    
    
            System.out.println(delawareShip.getSpaceshipName() + " is getting ready, currently in status: " +
            delawareShip.getStatus());
            delawareShip.Launch();
            System.out.println(delawareShip.getSpaceshipName() + " is: " + delawareShip.getStatus());
            delawareShip.Landed();
            System.out.println(delawareShip.getSpaceshipName() + " is: " + delawareShip.getStatus());
    
           
        }

        
        return true;
    }

    public boolean secondEvent() {
        boolean eventStatus = true;
        Astronaut firstAstronaut = new Astronaut("Vicente",21);

        Crew delawareCrew = new Crew();
        delawareCrew.addCrewMember(firstAstronaut);
        System.out.println("Event started with crew: " + delawareCrew);

        int numberOfSpaceshipsToBeSent = 5;

        for(int spaceshipCount = 0; spaceshipCount <= numberOfSpaceshipsToBeSent; spaceshipCount++) {
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
           
            System.out.println("status after: " + delawareShip);
        }
        return eventStatus;
    }
}

