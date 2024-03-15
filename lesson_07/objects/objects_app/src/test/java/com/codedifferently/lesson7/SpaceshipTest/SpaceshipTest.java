package com.codedifferently.lesson7.SpaceshipTest;


import org.junit.jupiter.api.Test;


import com.codedifferently.lesson7.Spaceship.Crew;
import com.codedifferently.lesson7.Spaceship.Spaceship;

public class SpaceshipTest {
  
    @Test
    public void launchTest() {
        Spaceship spaceship1 = new Spaceship(); // creates new spaceship

        spaceship1.setCrew(new Crew());
        System.out.println(spaceship1.getCrew());

        spaceship1.Launch();
        System.out.println(spaceship1.getStatus());

        spaceship1.Landed();
        System.out.println(spaceship1.getStatus());


    }

    


}

