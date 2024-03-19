package com.codedifferently.lesson7.sherllin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Dogtest {
  private Dog dog;

  @BeforeEach
  void setUp() {
    dog = new Dog(3, 10.5, "Brown", true, Breed.Poodle);
  }

  @Test
  void testInvalidBreedException() {
    assertThrows(
        Dog.InvalidBreedException.class,
        () -> {
          throw new Dog.InvalidBreedException("Invalid breed");
        });
  }

  @Test
  void testDogDetails() {
    // Create a Poodle dog
    Dog poodle = new Dog(3, 7.5, "White", true, Breed.Poodle);

    // Add toys to the Poodle's collection
    poodle.addToy("Squeaky Toy", "Chew Stick");

    // Check Poodle's details
    assertEquals(3, poodle.getAge());
    assertEquals(7.5, poodle.getWeight(), 0.01);
    assertEquals("White", poodle.getColor());
    assertTrue(poodle.getGender());
    assertEquals(Breed.Poodle, poodle.getBreed());
    assertEquals(2, poodle.getDogToys().size());

    // Create a Yorkshire Terrier (Yorkie) dog
    Dog yorkie = new Dog(2, 3.5, "Black and Tan", false, Breed.Yorkie);

    // Add toys to the Yorkie's collection
    yorkie.addToy("Tennis Ball", "Plush Toy");

    // Check Yorkie's details
    assertEquals(2, yorkie.getAge());
    assertEquals(3.5, yorkie.getWeight(), 0.01);
    assertEquals("Black and Tan", yorkie.getColor());
    assertFalse(yorkie.getGender());
    assertEquals(Breed.Yorkie, yorkie.getBreed());
    assertEquals(2, yorkie.getDogToys().size());

    // Create a Bulldog
    Dog bulldog = new Dog(4, 20.0, "Brown", true, Breed.Bulldog);

    // Add toys to the Bulldog's collection
    bulldog.addToy("Rubber Bone", "Tug-of-War Rope");

    // Check Bulldog's details
    assertEquals(4, bulldog.getAge());
    assertEquals(20.0, bulldog.getWeight(), 0.01);
    assertEquals("Brown", bulldog.getColor());
    assertTrue(bulldog.getGender());
    assertEquals(Breed.Bulldog, bulldog.getBreed());
    assertEquals(2, bulldog.getDogToys().size());
  }

  @Test
  void testGetAge() {
    assertEquals(3, dog.getAge());
  }

  @Test
  void testGetWeight() {
    assertEquals(10.5, dog.getWeight(), 0.001);
  }

  @Test
  void testGetColor() {
    assertEquals("Brown", dog.getColor());
  }

  @Test
  void testGetGender() {
    assertTrue(dog.getGender());
  }

  @Test
  void testGetBreed() {
    assertEquals(Breed.Poodle, dog.getBreed());
  }

  @Test
  void testIsBreed() {
    assertTrue(dog.isBreed(Breed.Poodle));
    assertFalse(dog.isBreed(Breed.Yorkie));
  }
}
