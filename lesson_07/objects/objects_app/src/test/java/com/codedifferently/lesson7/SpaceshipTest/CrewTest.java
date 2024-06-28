package com.codedifferently.lesson7.SpaceshipTest;

import com.codedifferently.lesson7.Spaceship.Astronaut;
import com.codedifferently.lesson7.Spaceship.Crew;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrewTest {
  @Test
  public void MinSizeTest() {
    Crew crew = new Crew();
    Integer min = crew.getMin();
    Assertions.assertEquals(2, min);
  }

  @Test
  public void MaxSizeTest() {
    Crew crew = new Crew();
    Integer max = crew.getMax();
    Assertions.assertEquals(4, max);
  }

  @Test
  public void addCrewMemberTest() {
    Astronaut astronaut = new Astronaut("Vicente", 21);
    Crew crew = new Crew();
    crew.addCrewMember(astronaut);
  }

  @Test
  public void removeCrewMemberTest() {
    Astronaut astronaut = new Astronaut("Vicente", 21);
    Crew crew = new Crew();
    crew.removeCrewMember(astronaut);
  }
}
