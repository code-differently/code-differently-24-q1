package main.java.com.codedifferently.lesson7.richhawkins;

import java.util.ArrayList;
import java.util.Scanner;


public class House {
    //     The class must have at least 5 member variables of at least 3 different types.
    ArrayList<String> streetName = new ArrayList<>();
    ArrayList<Integer> streetNum = new ArrayList<>();
    short yearBuilt;
    boolean hasGarage;
    short numberOfBedrooms;
    // You must also incorporate an enum type as well.
    public enum houseType {
        APARTMENT,
        BUNGALOW,
        COTTAGE,
        CAPECOD,
        COLONIAL,
        FARMHOUSE,
        MANSION,
        TINYHOME,
        TOWNHOUSE,
        SINGLEFAMILY,
        SPLITLEVEL,
    }
    // The class must have at least one constructor.
    
    // The class must have at least 3 member functions.
    // One of your functions must make use of a conditional expression.
    // One of your functions must make use of a loop.
    // You must use at least one custom exception.
}