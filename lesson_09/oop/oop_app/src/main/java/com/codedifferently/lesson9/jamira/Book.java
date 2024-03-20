package com.codedifferently.lesson9.jamira;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private List<String> authors= new ArrayList<>();
    private int numPages;
    private boolean checkedOut;

    // Constructor
    public Book(String title, String isbn, List<String> authors, int numPages, boolean checkedOut) {
        this.title = title;
        this.isbn = isbn;
        this.authors = authors;
        this.numPages = numPages;
        this.checkedOut = checkedOut; // Initially not checked out
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

