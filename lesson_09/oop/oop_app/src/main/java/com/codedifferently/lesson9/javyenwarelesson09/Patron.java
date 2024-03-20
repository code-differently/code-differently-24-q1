package com.codedifferently.lesson9.javyenwarelesson09;

public class Patron {
    
    private String name;
    private Boolean checkedOutBooks;
    
    public Patron(String name, Boolean checkedOutBooks) {
        this.name = name;
        this.checkedOutBooks = checkedOutBooks;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getCheckedOutBooks() {
        return checkedOutBooks;
    } 

    public void setCheckedOutBooks(boolean checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

}