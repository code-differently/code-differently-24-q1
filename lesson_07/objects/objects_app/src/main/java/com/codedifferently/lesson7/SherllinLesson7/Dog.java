package com.codedifferently.lesson7.SherllinLesson7;
import java.util.ArrayList;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")

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

    public void addToy(String toy) {
        dogToy.add(toy);
    }

    public ArrayList<String> getDogToys() {
        return dogToy;
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

    public static void main(String[] args) {
        for (int i = 0; i < Breed.values().length; i++) {
            System.out.println("Oh my godddd, Look at that " + Breed.values()[i]);
        }
    }
}