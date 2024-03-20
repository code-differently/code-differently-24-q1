package com.codedifferently.lesson9.javyenwarelesson09;

public class Book {

    private String title;
    private String isbn;
    private String author;
    private short numberOfPages;
    private boolean checkedOut;

    public Book(String title, String isbn, String author, short numberOfPages, boolean checkedOut) {
        this.title = title;
        this.isbn = isbn; 
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.checkedOut = checkedOut;
    }

    // Getters and Setters 
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(short numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public boolean  CheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}