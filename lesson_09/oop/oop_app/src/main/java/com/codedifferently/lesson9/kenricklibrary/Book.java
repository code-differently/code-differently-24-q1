package com.codedifferently.lesson9.kenricklibrary;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String ISBN;
    private String[] authors;
    private int numberOfPages;
    private boolean checkedOut;

    public Book(String title, String ISBN, String[] authors, int numberOfPages) {
        this.title = title;
        this.ISBN = ISBN;
        this.authors = authors;
        this.numberOfPages = numberOfPages;
        this.checkedOut = false;
    }

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }

    public String[] getAuthors() {
        return authors;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
