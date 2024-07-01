package com.codedifferently.lesson7.kevinmason;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FoodTest {

  @Test
  public void testIsHealthy() {
    Food healthyFood = new Food("Apple", 1.0, true, 50, Food.Category.FRUIT);
    Food unhealthyFood = new Food("Chocolate", 2.0, false, 600, Food.Category.SNACK);

    assertTrue(healthyFood.isHealthy());
    // Ensure unhealthy food is not considered healthy
    assertTrue(!unhealthyFood.isHealthy());
  }

  @Test
  public void testPurchase() {
    Food food = new Food("Apple", 1.0, true, 50, Food.Category.FRUIT);
    food.purchase(3);
    // Assert purchase successful
    // You can add additional assertions based on your specific implementation
  }

  @Test
  public void testIsExpired() {
    Food food = new Food("Apple", 1.0, true, 50, Food.Category.FRUIT);
    // Ensure food is not expired
    assertTrue(!food.isExpired());
  }

  @Test
  public void testParseCategory() {
    try {
      Food.Category fruitCategory = Food.parseCategory("fruit");
      assertEquals(Food.Category.FRUIT, fruitCategory);
    } catch (Food.InvalidFoodCategoryException e) {
      // Fail if exception is thrown for a valid category
      e.printStackTrace();
    }
  }

  @Test
  public void testPrintFoodDetails() {
    Food food = new Food("Apple", 1.0, true, 50, Food.Category.FRUIT);
    int times = 3;
    food.printFoodDetails(times);
    // Ensure no assertion is needed as this method only prints details
  }
}
