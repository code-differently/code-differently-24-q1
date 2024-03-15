package com.codedifferently.lesson7.Spaceship;

import java.util.Arrays;

public class Crew {

    Astronaut[] astronautArray = new Astronaut[6];

    private final Integer MIN = 3;
    private final Integer MAX = 6;

    public Integer getMin() {
        return MIN;
    }

    public Integer getMax() {
        return MAX;
    }

    public void addCrewMember(Astronaut astronaut) {
        astronautArray[0] = astronaut; // improve
    }

    public void removeCrewMember(Astronaut astronaut) {
        astronautArray[0] = null; // improve
    }


    @Override
    public String toString() {
        return "Crew{" + 
                "astronautArray=" + Arrays.toString(astronautArray) +
                ", MIN=" + MIN +
                ", MAX=" + MAX +
                '}';
    }

}
