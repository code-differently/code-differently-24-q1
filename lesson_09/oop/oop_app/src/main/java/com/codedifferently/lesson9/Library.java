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

public class Main {
    public static void main(String[] args) {
        // Creating books
        Book book1 = new Book("The Dark Knight Returns", "9780743273565", "F. Scott Fitzgerald", 180);
        Book book2 = new Book("Batman And Robin", "9780061120084", "", 324);

        // Creating patrons
        Patron patron1 = new Patron("Alice");
        Patron patron2 = new Patron("Bob");

        // Creating library
        Library library = new Library();

        // Adding books to library
        library.addBook(book1);
        library.addBook(book2);

        // Registering patrons
        library.registerPatron(patron1);
        library.registerPatron(patron2);

        // Checking out books
        library.checkOutBook(patron1, book1);
        library.checkOutBook(patron2, book2);

        // Attempting to check out an already checked-out book
        library.checkOutBook(patron1, book1);

        // Returning books
        library.returnBook(patron1, book1);
        library.returnBook(patron2, book2);

        // Removing a book from the library
        library.removeBook(book2);
    }
}

