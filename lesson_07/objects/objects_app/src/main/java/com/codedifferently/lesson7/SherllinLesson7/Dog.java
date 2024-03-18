package com.codedifferently.lesson7.sherllinlesson7;

import java.util.ArrayList;

public class Dog {

  public static class InvalidBreedException extends Exception {
    public InvalidBreedException(String message) {
      super(message);
    }
  }

  private int age;
  private double weight;
  private String color;
  private boolean gender;
  private Breed breed;
  private ArrayList<String> dogToy;

  public Dog(int age, double weight, String color, boolean gender, Breed breed) {
    this.age = age;
    this.weight = weight;
    this.color = color;
    this.gender = gender;
    this.breed = breed;
    this.dogToy = new ArrayList<>();
  }

  public void addToy(String... toys) {
    for (String toy : toys) {
      dogToy.add(toy);
    }
  }

  public ArrayList<String> getDogToys() {
    return dogToy;
  }

  public void displayToys() {
    System.out.println("Toys for " + breed + " dog:");
    for (String toy : dogToy) {
      System.out.println(toy);
    }
  }

  public int getAge() {
    return age;
  }

  public double getWeight() {
    return weight;
  }

  public String getColor() {
    return color;
  }

  public boolean getGender() {
    return gender;
  }

  public Breed getBreed() {
    return breed;
  }

  public boolean isBreed(Breed val) {
    return this.breed == val;
  }
}
