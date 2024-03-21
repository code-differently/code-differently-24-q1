package com.codedifferently.lesson9.jamira;


import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private String author;
    private int numPages;
    private boolean checkedOut;

    // Constructor
    public Book(String title, String isbn, List<String> list, int numPages, boolean checkedOut) {
        this.title = title;
        this.isbn = isbn;
        this.author = list;
        this.numPages = numPages;
        this.checkedOut = checkedOut; // Initially not checked out
    }

    public Book(String title, int isbn, String author, int numPages2, boolean checkedOut2) {
        //TODO Auto-generated constructor stub
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

