package com.codedifferently.lesson7.mekhiwilliams;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SneakerTest {

  @Test
  void testValidSize() {
    Sneaker sneaker = new Sneaker("Nike", "Air Max", 10.0, Sneaker.SneakerType.RUNNING, false);
    assertDoesNotThrow(() -> sneaker.validateSize());
  }

  @Test
  void testInvalidSize() {
    Sneaker sneaker = new Sneaker("Adidas", "Yeezy", 12.0, Sneaker.SneakerType.CASUAL, true);
    assertThrows(Sneaker.InvalidSizeException.class, () -> sneaker.validateSize());
  }

  

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
}
