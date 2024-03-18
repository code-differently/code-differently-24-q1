package com.codedifferently.lesson7.SpaceshipTest;

import com.codedifferently.lesson7.Spaceship.Crew;
import com.codedifferently.lesson7.Spaceship.CrewSizeException;
import com.codedifferently.lesson7.Spaceship.Spaceship;
import org.junit.jupiter.api.Test;

public class SpaceshipTest {

  @Test
  public void launchTest() throws CrewSizeException {
    Spaceship spaceship1 = new Spaceship(); // creates new spaceship

    spaceship1.setCrew(new Crew());
    System.out.println(spaceship1.getCrew());

    spaceship1.Launch();
    System.out.println(spaceship1.getStatus());

    spaceship1.Landed();
    System.out.println(spaceship1.getStatus());
  }
}
