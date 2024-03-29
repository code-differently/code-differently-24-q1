package com.codedifferently.lesson7.kenricksutherland;

import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.lesson7.kenricksutherland.Person.Gender;
import com.codedifferently.lesson7.kenricksutherland.Person.InvalidAgeException;
import org.junit.jupiter.api.Test;

public class PersonsTest {

  @Test
  void testPersonInfo() {
    try {
      Person person = new Person("John Doe", 30, Gender.MALE, "Software Engineer", "USA");
      assertEquals("John Doe", person.getName());
      assertEquals(30, person.getAge());
      assertEquals(Gender.MALE, person.getGender());
      assertEquals("Software Engineer", person.getOccupation());
      assertEquals("USA", person.getNationality());
    } catch (Person.InvalidAgeException e) {
      fail("InvalidAgeException should not be thrown in this test.");
    }
  }

  @Test
  void testGetGenderPronoun() throws InvalidAgeException {
    Person person1 = new Person("John Doe", 30, Gender.MALE, "Software Engineer", "USA");
    assertEquals("He", person1.getGenderPronoun());

    Person person2 = new Person("Jane Doe", 25, Gender.FEMALE, "Doctor", "Canada");
    assertEquals("She", person2.getGenderPronoun());

    Person person3 = new Person("Alex Smith", 40, Gender.OTHER, "Artist", "France");
    assertEquals("They", person3.getGenderPronoun());
  }

  @Test
  void testGetPersonInfo() {
    try {
      Person person = new Person("John Doe", 30, Gender.MALE, "Software Engineer", "USA");
      assertEquals(5, person.getPersonInfo().size());
    } catch (Person.InvalidAgeException e) {
      fail("InvalidAgeException should not be thrown in this test.");
    }
  }

  @Test
  void testDisplayPersonInfo() {
    try {
      Person person = new Person("John Doe", 30, Gender.MALE, "Software Engineer", "USA");
      assertDoesNotThrow(() -> person.displayPersonInfo());
    } catch (Person.InvalidAgeException e) {
      fail("InvalidAgeException should not be thrown in this test.");
    }
  }

  @Test
  void testGetOccupationStatus() {
    try {
      Person employedPerson = new Person("John Doe", 30, Gender.MALE, "Software Engineer", "USA");
      assertEquals("Employed as a Software Engineer", employedPerson.getOccupationStatus());

      Person unemployedPerson = new Person("Jane Doe", 25, Gender.FEMALE, "", "Canada");
      assertEquals("Unemployed", unemployedPerson.getOccupationStatus());
    } catch (Person.InvalidAgeException e) {
      fail("InvalidAgeException should not be thrown in this test.");
    }
  }
}
