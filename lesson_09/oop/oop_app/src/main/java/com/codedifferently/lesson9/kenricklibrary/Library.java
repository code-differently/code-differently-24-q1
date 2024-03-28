package com.codedifferently.lesson9.kenricklibrary;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Patron> patrons;

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

    public void checkOutBook(Book book, Patron patron) {
        if (books.contains(book)) {
            patron.checkOutBook(book);
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is not available in the library");
        }
    }

    public void returnBook(Book book, Patron patron) {
        if (books.contains(book)) {
            patron.returnBook(book);
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is not available in the library");
        }
    }

    public void printAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    public void printRegisteredPatrons() {
        System.out.println("Registered Patrons:");
        for (Patron patron : patrons) {
            System.out.println("- " + patron.getName());
        }
    }
}
