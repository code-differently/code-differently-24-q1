package com.codedifferently.lesson7.kyvonthompson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FrogTest {

  @Test
  // Frog actions
  public void testjump() {

    // Creating a new Frog instance
    Frog frog = new Frog("green", 5, 2, 8.2, "bulletFrog");
    // Getting frog details
    assertEquals("The green frog jumps!", frog.jump());
  }

  private void jumps() {
    throw new UnsupportedOperationException("Unimplemented method 'jumps'");
  }
}
