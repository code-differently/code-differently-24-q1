package com.codedifferently.lesson7.MekhiWilliams;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MekhiWilliams07Test {

  @Test
  void testSneakerDetails() {
    Sneaker sneaker = new Sneaker("Nike", "Air Max", 10.5, Sneaker.SneakerType.RUNNING, false);
    assertEquals("Nike", sneaker.getBrand());
    assertEquals("Air Max", sneaker.getModel());
    assertEquals(10.5, sneaker.getSize());
    assertEquals(Sneaker.SneakerType.RUNNING, sneaker.getType());
    assertEquals(false, sneaker.isLimitedEdition());
  }

  @Test
  void testPopularity() {
    Sneaker sneaker1 = new Sneaker("Adidas", "Yeezy", 9.5, Sneaker.SneakerType.CASUAL, true);
    Sneaker sneaker2 = new Sneaker("Nike", "Air Force 1", 11.0, Sneaker.SneakerType.CASUAL, false);

    assertEquals("Limited Edition", sneaker1.getPopularity());
    assertEquals("Regular Edition", sneaker2.getPopularity());
  }

  @Test
  void testValidateSize() {
    Sneaker sneaker = new Sneaker("Puma", "RS-X", -1, Sneaker.SneakerType.CASUAL, false);

    try {
      sneaker.validateSize();
    } catch (Sneaker.InvalidSizeException e) {
      assertEquals("Size should be greater than 0", e.getMessage());
    }
  }
}

