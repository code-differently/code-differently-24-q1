package com.codedifferently.lesson9;

import java.util.ArrayList;

import com.codedifferently.lesson9.KyvonThompsonlesson09.Book;

public class Library {
    ArrayList<Book> books;
    ArrayList<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    public boolean checkOutBook(Patron patron, Book book) {
        if (books.contains(book) && patron.checkOutBook(book)) {
            books.remove(book);
            return true;
        } else {
            return false;
        }
    }

    public boolean returnBook(Patron patron, Book book) {
        if (patron.returnBook(book)) {
            books.add(book);
            return true;
        } else {
            return false;
        }
    }
}