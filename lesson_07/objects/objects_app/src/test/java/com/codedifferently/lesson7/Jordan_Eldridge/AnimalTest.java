package com.codedifferently.lesson7.Jordan_Eldridge;

import com.codedifferently.lesson7.Jordan_Eldridge.Animal.AnimalType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @Test
    public void testCanBreathe() {
        Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
        assertTrue(animal.isCanBreathe());
    }

    @Test
    public void testGetAge() {
        Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
        assertEquals(5, animal.getAge());
    }

    @Test
    public void testGetColor() {
        Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
        assertEquals("Brown", animal.getColor());
    }

    @Test
    public void testGetType() {
        Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
        assertEquals(AnimalType.MAMMAL, animal.getType());
    }

    @Test
    public void testSetName() {
        Animal animal = new Animal("Dog", true, 5, "Brown", "Bark", AnimalType.MAMMAL);
        animal.setName("Cat");
        assertEquals("Cat", animal.getName());
    }
}