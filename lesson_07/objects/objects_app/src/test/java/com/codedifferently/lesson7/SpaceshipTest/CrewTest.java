package com.codedifferently.lesson7.SpaceshipTest;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson7.Spaceship.Astronaut;
import com.codedifferently.lesson7.Spaceship.Crew;

public class CrewTest {
    @Test
    public void MinSizeTest() {
        Crew crew = new Crew();
        Integer min = crew.getMin();
        Assertions.assertEquals(3,min);

    }

    @Test
    public void MaxSizeTest() {
        Crew crew = new Crew();
        Integer max = crew.getMin();
        Assertions.assertEquals(6,max);
    }

    @Test
    public void addCrewMemberTest() {
        Astronaut astronaut = new Astronaut("Vicente",21);
        Crew crew = new Crew();
        crew.addCrewMember(astronaut);

    }

    @Test
    public void removeCrewMemberTest() {
        Astronaut astronaut = new Astronaut("Vicente",21);
        Crew crew = new Crew();
        crew.removeCrewMember(astronaut);

    }
    

 }
