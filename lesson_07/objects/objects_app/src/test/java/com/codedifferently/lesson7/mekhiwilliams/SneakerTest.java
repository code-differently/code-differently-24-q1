package com.codedifferently.lesson7.mekhiwilliams;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
