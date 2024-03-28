package com.codedifferently.lesson9.kenricklibrary;

import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String name;
    private List<Book> checkedOutBooks;

    public Patron(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    public void checkOutBook(Book book) {
        if (!book.isCheckedOut()) {
            book.setCheckedOut(true);
            checkedOutBooks.add(book);
            System.out.println("Book \"" + book.getTitle() + "\" checked out successfully to " + name);
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" is already checked out");
        }
    }

    public void returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            book.setCheckedOut(false);
            checkedOutBooks.remove(book);
            System.out.println("Book \"" + book.getTitle() + "\" returned successfully by " + name);
        } else {
            System.out.println("Book \"" + book.getTitle() + "\" was not checked out by " + name);
        }
    }
}
