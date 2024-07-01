package com.codedifferently.lesson7.SpaceshipTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson7.Spaceship.Crew;
import com.codedifferently.lesson7.Spaceship.CrewSizeException;
import com.codedifferently.lesson7.Spaceship.Spaceship;
import org.junit.jupiter.api.Test;

public class SpaceshipTest {

  @Test
  public void crewSizeExceptionTest() throws CrewSizeException {
    Spaceship spaceship1 = new Spaceship(); // creates new spaceship

    spaceship1.setCrew(new Crew());
    System.out.println(spaceship1.getCrew());

    Exception exception =
        assertThrows(
            CrewSizeException.class,
            () -> {
              spaceship1.Launch();
            });

    assertEquals(" cannot be launched because needs a proper crew size", exception.getMessage());
  }
}
