package com.codedifferently.lesson7.kyvonthompson;

public class Frog {
  // Frog Attributes

  private String color;
  private int age; // Age in years
  private int size; // Size in inches
  private double weight; // Weigh in pounds
  private String breed;

  // Constructer to create brand new frogger
  public Frog(String color, int age, int size, double weight, String breed) {

    this.color = color;
    this.age = age;
    this.size = size;
    this.weight = weight;
    this.breed = breed;
  }

  public enum frogColor {
    GREEN,
    BLUE,
    RED,
    PURPLE,
    PINK,
    WHITE,
    BROWN,
  }

  public enum frogType {
    TREE_FROG,
    BULLFROG,
    POISON_DART_FROG,
    LEOPARD_FROG,
    COMMON_FROG,
    GLASS_FROG
  }

  // Behaviors of a Frog

  // The frog jumps
  public String jump() {
    return "The " + color + " frog jumps!";
  }

  // The frog croaks
  public void croak() {
    System.out.println("The " + color + " frog says: Croak!");
  }

  // Getter for color
  public String getColor() {
    return color;
  }

  // Setter for color
  public void setColor(String color) {
    this.color = color;
  }

  // Getter for size
  public int getSize() {
    return size;
  }

  // Setter for size
  public void setSize(int size) {
    this.size = size;
  }

  // Getter for age
  public int getAge() {
    return age;
  }

  // Setter for age
  public void setAge(int age) {
    this.age = age;
  }

  // Getter for weight
  public double getWeight() {
    return weight;
  }

  // Setter for weight
  public void setWeight(double weight) {
    this.weight = weight;
  }

  // Getter for breed
  public String getBreed() {
    return breed;
  }

  // Setter for breed
  public void setBreed(String breed) {
    this.breed = breed;
  }
}
