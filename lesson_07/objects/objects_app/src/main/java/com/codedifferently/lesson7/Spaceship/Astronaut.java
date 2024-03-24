package com.codedifferently.lesson7.Spaceship;

public class Astronaut {

  private String name;
  private Integer age;

  public Astronaut(String newName, Integer newAge) {
    age = newAge;
    name = newName;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  @Override
  public String toString() {
    return "Astronaut{" + "name='" + name + '\'' + ", age=" + age + '}';
  }
}
