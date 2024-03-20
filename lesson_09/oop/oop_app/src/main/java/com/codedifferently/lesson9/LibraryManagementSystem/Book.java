package com.codedifferently.lesson9.LibraryManagementSystem;

public class Book {
    String title;
    String author;
    int isbn;
    int numberofpages;


    public Book(String title, String isbn, String author, int pages) {
        
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getNumberofpages() {
        return numberofpages;
    }

    public void setNumberofpages(int numberofpages) {
        this.numberofpages = numberofpages;
    }

    public String getTitle() {
    return title;
    }

    public void setTitle(String title) {
    this.title = title;
    }



}