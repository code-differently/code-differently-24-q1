package com.codedifferently.lesson9;

import java.util.ArrayList;

import com.codedifferently.lesson9.KyvonThompsonlesson09.Book;

public class Patron {
    // Patron information
    private String patronName;
    private ArrayList<Book> checkedOutBooks; // It's good practice to make fields private

    // Patron constructor
    public Patron(String patronName) {
        this.patronName = patronName;
        this.checkedOutBooks = new ArrayList<>();
    }

    // Getter for the Patron's name
    public String getPatronName() {
        return patronName;
    }

    // Setter for Patron's name
    public void setPatronName(String patronName) {
        this.patronName = patronName;
    }

    // Getter for the books the patron has checked out
    public ArrayList<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    // Method to add a book to the checkedOutBooks list
    public void addBook(Book book) {
        checkedOutBooks.add(book);
    }

    // Method to remove a book from the checkedOutBooks list
    public boolean removeBook(Book book) {
        return checkedOutBooks.remove(book);
    }

    // Optionally, if you really need a setter for replacing the whole list
    public void setCheckedOutBooks(ArrayList<Book> checkedOutBooks) {
        this.checkedOutBooks = checkedOutBooks;
    }
    public boolean checkOutBook(Book book) {
        if (book.checkOut()) {
            checkedOutBooks.add(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);
            book.returnBook();
            return true;
        } else {
            return false;
        }
    }

}