package com.codedifferently.lesson7.kyvonthompson;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class Frog {

  public Frog(String string, int i, int j, double d, String string2) {
    
  

  @Test
  // Frog actions
  public void testjump() {

    // Creating a new Frog instance
    Frog frog = new Frog("green", 5, 2, 8.2, "bulletFrog");
    // Getting frog details
    assertEquals("The green frog jumps!", frog.jumps());
  }

  private Frogtest jumps() {
    throw new UnsupportedOperationException("Unimplemented method 'jumps'");
  }
  }
  // System.out.println(
  //     "frog details: Color - "
  //         + frog.getColor()
  //         + ", Size - "
  //         + frog.getSize()
  //         + ", Age - "
  //         + frog.getAge()
  //         + ",Weight - "
  //         + frog.getWeight()
  //         + ",Weight"
  //         + frog.getBreed());