package com.codedifferently.lesson7.Spaceship;

public class Spaceship {

    private String status = "parked"; // start with a parked status
    private Crew crew = new Crew(); // creates empty crew


    public void Launch() {
        status = "launched";
    }
    
    public void Landed() {
        status = "Landed";
    }

    public String getStatus() {
        return status;
    }


    public void addCrewMember (Astronaut astronaut) {
        crew.addCrewMember(astronaut);
    }


    public Crew getCrew(){
        return crew;
    }




}