package com.codedifferently.lesson9.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a patron of the library.
 */
public class Patron {
    private String name;
    private List<Book> checkedOutBooks;

    /**
     * Constructs a new Patron instance with the given name.
     *
     * @param name The name of the patron.
     */
    public Patron(String name) {
        this.name = name;
        this.checkedOutBooks = new ArrayList<>();
    }

    /**
     * Gets the name of the patron.
     *
     * @return The name of the patron.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the patron.
     *
     * @param name The name of the patron.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of books checked out by the patron.
     *
     * @return The list of checked out books.
     */
    public List<Book> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    /**
     * Adds a book to the list of books checked out by the patron.
     *
     * @param book The book to be added.
     */
    public void addCheckedOutBook(Book book) {
        checkedOutBooks.add(book);
    }

    /**
     * Removes a book from the list of books checked out by the patron.
     *
     * @param book The book to be removed.
     */
    public void removeCheckedOutBook(Book book) {
        checkedOutBooks.remove(book);
    }
}
