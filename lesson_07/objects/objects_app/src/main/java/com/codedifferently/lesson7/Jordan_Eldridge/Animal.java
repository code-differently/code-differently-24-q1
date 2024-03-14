package com.codedifferently.lesson7.Jordan_Eldridge;

public class Animal {

  public enum AnimalType {
    MAMMAL,
    BIRD,
    REPTILE,
    FISH,
    AMPHIBIAN,
    INSECT
  }

  private String name;
  private boolean canBreathe;
  private int age;
  private String color;
  private String sound;
  private AnimalType type;

  public Animal(
      String name, boolean canBreathe, int age, String color, String sound, AnimalType type) {
    this.name = name;
    this.canBreathe = canBreathe;
    this.age = age;
    this.color = color;
    this.sound = sound;
    this.type = type;
  }

  public String canFly() {
    return (type == AnimalType.BIRD) ? "This animal can fly!" : "This animal cannot fly.";
  }

  public void makeSound() {
    System.out.println("The " + this.name + " makes a sound!");
  }

  public void growOlder() {
    this.age += 1;
    System.out.println("The " + this.name + " is now " + this.age + " years old.");
  }

  public void changeColor(String newColor) {
    this.color = newColor;
    System.out.println("The " + this.name + " has changed color to " + this.color + ".");
  }

  public String getName() {
    return name;
  }

  public boolean isCanBreathe() {
    return canBreathe;
  }

  public int getAge() {
    return age;
  }

  public String getColor() {
    return color;
  }

  public String getSound() {
    return sound;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCanBreathe(boolean canBreathe) {
    this.canBreathe = canBreathe;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public void setSound(String sound) {
    this.sound = sound;
  }

  public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
      super(message);
    }
  }

  public void repeatSound(int times) {
    for (int i = 0; i < times; i++) {
      System.out.println(this.getSound());
    }
  }

  public String toString() {
    return "Animal [name="
        + name
        + ", canBreathe="
        + canBreathe
        + ", age="
        + age
        + ", color="
        + color
        + ", sound="
        + sound
        + "]";
  }

  public Object getType() {
    if (this.type == null) {
      throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }
    return this.type;
  }
}
