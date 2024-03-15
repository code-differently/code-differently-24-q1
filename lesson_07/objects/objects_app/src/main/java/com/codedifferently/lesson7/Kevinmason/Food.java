package com.codedifferently.lesson7.Kevinmason;

public class Food {
  // Member variables
  private String name;
  private double price;
  private boolean isVegetarian;
  private int calories;
  private Category category;

  // Custom exception for handling invalid food category
  public static class InvalidFoodCategoryException extends Exception {
    public InvalidFoodCategoryException(String message) {
      super(message);
    }
  }

  // Enum for food categories
  public enum Category {
    FRUIT,
    VEGETABLE,
    MEAT,
    DAIRY,
    GRAIN,
    SNACK,
    BEVERAGE
  }

  // Constructor
  public Food(String name, double price, boolean isVegetarian, int calories, Category category) {
    this.name = name;
    this.price = price;
    this.isVegetarian = isVegetarian;
    this.calories = calories;
    this.category = category;
  }

  // Getter method for calories
  public int getCalories() {
    return calories;
  }

  // Function to check if the food is healthy based on calorie count
  public boolean isHealthy() {
    return calories < 500;
  }

  // Function to simulate eating the food
  public void eat(int portions) {
    if (portions <= 0) {
      System.out.println("Invalid number of portions.");
      return;
    }
    System.out.println("Eating " + portions + " portions of " + name);
    // Adjusting calories based on portions eaten
    calories -= portions * 50; // Assuming each portion has 50 calories
    if (calories < 0) {
      calories = 0; // Calories cannot be negative
    }
    System.out.println("Remaining calories: " + calories);
  }

  // Function to simulate purchasing the food
  public void purchase(int quantity) {
    if (quantity <= 0) {
      System.out.println("Invalid quantity.");
      return;
    }
    System.out.println("Purchasing " + quantity + " " + name);
    // Adjusting quantity based on purchase
    // Dummy implementation, not considering actual stock management
    System.out.println("Purchase successful!");
  }

  // Function to check if the food is expired (dummy implementation)
  public boolean isExpired() {
    // Dummy implementation, always returns false
    return false;
  }

  // Custom method to handle invalid food categories
  public static Category parseCategory(String category) throws InvalidFoodCategoryException {
    switch (category.toLowerCase()) {
      case "fruit":
        return Category.FRUIT;
      case "vegetable":
        return Category.VEGETABLE;
      case "meat":
        return Category.MEAT;
      case "dairy":
        return Category.DAIRY;
      case "grain":
        return Category.GRAIN;
      case "snack":
        return Category.SNACK;
      case "beverage":
        return Category.BEVERAGE;
      default:
        throw new InvalidFoodCategoryException("Invalid food category: " + category);
    }
  }
}
