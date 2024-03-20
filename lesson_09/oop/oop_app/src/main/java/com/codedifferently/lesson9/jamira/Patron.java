package com.codedifferently.lesson9.jamira;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private List<Book> checkedOutBooks;

    // Constructor
    public Patron(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void setCheckedOutBooks(List<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }

    public void addCheckedOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    public void removeCheckedOutBook(Book book) {
        checkedOutBooks.remove(book);
    }

    public boolean hasCheckedOutBook(Book book) {
        return checkedOutBooks.contains(book);
    }
}
