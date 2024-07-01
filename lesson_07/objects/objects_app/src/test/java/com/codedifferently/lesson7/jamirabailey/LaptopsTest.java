package com.codedifferently.lesson7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson7.Jamiralesson7.Laptops;
import org.junit.jupiter.api.Test;

public class LaptopsTest {

  @Test
  public void testCalculateTotalStorage() {
    Laptops laptop = new Laptops("Dell", 4, 15.6, 512);

    // Test case 1: Single storage amount
    int[] storageAmounts1 = {512};
    int expectedTotalStorage1 = 512;
    assertEquals(expectedTotalStorage1, laptop.calculateTotalStorage(storageAmounts1));
  }

  @Test
  public void testBrandValidation() {
    Laptops laptop = new Laptops("Dell", 4, 15.6, 512);
    laptop.Brand = "Dell";
    assertTrue(laptop.validateBrand());
  }

  @Test
  public void testConstructor() {
    Laptops laptop = new Laptops("BrandX", 4, 15.6, 512);

    assertEquals("BrandX", laptop.Brand);
    assertEquals(4, laptop.Ports);
    assertEquals(15.6, laptop.Screensize, 0.01);
    assertEquals(512, laptop.storageAmount);
  }
}
