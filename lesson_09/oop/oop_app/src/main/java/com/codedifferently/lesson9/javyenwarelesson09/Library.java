package com.codedifferently.lesson9.javyenwarelesson09;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Methods to add/remove books
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to register new patrons
    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to check out books to patrons
    public void checkOutBook(Book book, Patron patron) {
        if (!book.isCheckedOut()) {
            book.setCheckedOut(true);
            patron.getCheckedOutBooks().add(book);
        } else {
            System.out.println("Book is already checked out.");
        }
    }

    // Method to return books from patrons
    public void returnBook(Book book, Patron patron) {
        if (patron.getCheckedOutBooks().contains(book)) {
            book.setCheckedOut(false);
            patron.getCheckedOutBooks().remove(book);
        } else {
            System.out.println("Patron did not check out this book.");
        }
    }


}