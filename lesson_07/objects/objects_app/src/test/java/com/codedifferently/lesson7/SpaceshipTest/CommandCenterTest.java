package com.codedifferently.lesson7.SpaceshipTest;

import com.codedifferently.lesson7.Spaceship.CommandCenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommandCenterTest {

  @Test
  public void firstSuccessfulEvent() {
    CommandCenter commandCenter = new CommandCenter();
    boolean eventStatus = commandCenter.firstEvent();
    Assertions.assertTrue(eventStatus);
  }

  @Test
  public void secondFailedEvent() {
    CommandCenter commandCenter = new CommandCenter();
    boolean eventStatus = commandCenter.secondEvent();
    Assertions.assertFalse(eventStatus);
  }
}
