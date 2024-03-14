package com.codedifferently.lesson7.jordan_eldridge;

import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson7.jordan_eldridge.Animal;
import com.codedifferently.lesson7.jordan_eldridge.Animal.AnimalType;
import com.codedifferently.lesson7.jordan_eldridge.Animal.InvalidAgeException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AnimalTest {

  @Test
  public void testConstructor() {
    Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
    assertEquals("Dog", animal.getName());
    assertTrue(animal.getCanBreathe());
    assertEquals(5, animal.getAge());
    assertEquals("Brown", animal.getColor());
    assertEquals(AnimalType.MAMMAL, animal.getType());
  }

  @Test
  public void testCanFly() {
    Animal animal = new Animal("Owl", true, 1, "Brown", "whistles", AnimalType.BIRD);
    assertEquals("This animal can fly!", animal.canFly());
  }

  @Test
  public void testMakeSound() {
    Animal animal = new Animal("lizard", true, 3, "Green", "Hissing", AnimalType.REPTILE);
    String sound = animal.makeSound();
    assertEquals("Hissing", sound);
  }

  @Test
  public void testRepeatSound() {
    Animal snake = new Animal("henry", true, 2, "brown", "hissing", AnimalType.REPTILE);
    snake.repeatSound(2);
  }

  @Test
  public void testSetAge() {
    Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
    Exception exception =
        assertThrows(
            InvalidAgeException.class,
            () -> {
              animal.setAge(-1);
            });

    String expectedMessage = "Age cannot be negative.";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void testGetAllAnimals() {
    Animal dog = new Animal("Josie", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
    Animal cat = new Animal("hunter", true, 3, "Black", "Meow", AnimalType.MAMMAL);
    Animal bird = new Animal("Owl", true, 1, "Brown", "whistles", AnimalType.BIRD);

    List<Animal> allAnimals = Animal.getAllAnimals();

    assertTrue(allAnimals.contains(dog));
    assertTrue(allAnimals.contains(cat));
    assertTrue(allAnimals.contains(bird));
    assertEquals(8, allAnimals.size());
  }
}
