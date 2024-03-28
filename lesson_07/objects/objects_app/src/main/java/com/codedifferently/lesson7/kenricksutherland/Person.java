package com.codedifferently.lesson7.kenricksutherland;

import java.util.ArrayList;

public class Person {
  private String name;
  private int age;
  private Gender gender;
  private String occupation;
  private String nationality;

  public enum Gender {
    MALE,
    FEMALE,
    OTHER
  }

  // Custom exception for invalid age
  public static class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
      super(message);
    }
  }

  public Person(String name, int age, Gender gender, String occupation, String nationality)
      throws InvalidAgeException {
    if (age <= 0) {
      throw new InvalidAgeException("Age must be a positive integer.");
    }
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.occupation = occupation;
    this.nationality = nationality;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Gender getGender() {
    return gender;
  }

  public String getOccupation() {
    return occupation;
  }

  public String getNationality() {
    return nationality;
  }

  public String getGenderPronoun() {
    return switch (gender) {
      case MALE -> "He";
      case FEMALE -> "She";
      default -> "They";
    };
  }

  // Function using a collection (ArrayList)
  public ArrayList<String> getPersonInfo() {
    ArrayList<String> info = new ArrayList<>();
    info.add("Name: " + name);
    info.add("Age: " + age);
    info.add("Gender: " + gender);
    info.add("Occupation: " + occupation);
    info.add("Nationality: " + nationality);
    return info;
  }

  // Function using a loop
  public void displayPersonInfo() {
    ArrayList<String> info = getPersonInfo();
    for (String line : info) {
      System.out.println(line);
    }
  }

  // Function using a conditional expression
  public String getOccupationStatus() {
    return occupation.isEmpty() ? "Unemployed" : "Employed as a " + occupation;
  }
}
