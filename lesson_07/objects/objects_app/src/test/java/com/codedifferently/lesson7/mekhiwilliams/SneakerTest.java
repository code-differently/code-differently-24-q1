package com.codedifferently.lesson7.mekhiwilliams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SneakerTest {

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

  // Additional tests

  @Test
  void testLimitedEditionTrue() {
    Sneaker sneaker = new Sneaker("Nike", "Air Jordan", 9.0, Sneaker.SneakerType.BASKETBALL, true);
    assertTrue(sneaker.isLimitedEdition());
  }

  @Test
  void testLimitedEditionFalse() {
    Sneaker sneaker = new Sneaker("Adidas", "Superstar", 8.5, Sneaker.SneakerType.CASUAL, false);
    assertFalse(sneaker.isLimitedEdition());
  }

  @Test
  void testSneakerType() {
    Sneaker sneaker = new Sneaker("Puma", "Clyde", 10.0, Sneaker.SneakerType.CASUAL, false);
    assertEquals(Sneaker.SneakerType.CASUAL, sneaker.getType());
  }

  @Test
  void testBrandAndModel() {
    Sneaker sneaker = new Sneaker("Reebok", "Classic Leather", 9.0, Sneaker.SneakerType.CASUAL, true);
    assertEquals("Reebok", sneaker.getBrand());
    assertEquals("Classic Leather", sneaker.getModel());
  }

  @Test
  void testInvalidSizeExceptionMessage() {
    try {
      Sneaker sneaker = new Sneaker("New Balance", "574", -1, Sneaker.SneakerType.CASUAL, false);
      sneaker.validateSize();
    } catch (Sneaker.InvalidSizeException e) {
      assertEquals("Size should be greater than 0", e.getMessage());
    }
  }
}


