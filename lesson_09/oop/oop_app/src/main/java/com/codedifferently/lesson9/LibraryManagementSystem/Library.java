package com.codedifferently.lesson9.LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library that manages a collection of books and patrons.
 */
public class Library {
    private List<Book> books;
    private List<Patron> patrons;

    /**
     * Constructs a new Library instance with empty collections of books and patrons.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    /**
     * Adds a book to the library's collection.
     *
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library's collection.
     *
     * @param book The book to be removed.
     */
    public void removeBook(Book book) {
        books.remove(book);
    }

    /**
     * Registers a new patron with the library.
     *
     * @param patron The patron to be registered.
     */
    public void registerPatron(Patron patron) {
        patrons.add(patron);
    }

    /**
     * Checks out a book to a patron.
     *
     * @param book   The book to be checked out.
     * @param patron The patron who is checking out the book.
     */
    public void checkOutBook(Book book, Patron patron) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book not found in the library");
        }
        if (!patrons.contains(patron)) {
            throw new IllegalArgumentException("Patron not registered in the library");
        }
        if (book.isCheckedOut()) {
            throw new IllegalStateException("Book is already checked out");
        }
        book.setCheckedOut(true);
        patron.addCheckedOutBook(book);
    }

    /**
     * Returns a book that was checked out by a patron.
     *
     * @param book   The book to be returned.
     * @param patron The patron who is returning the book.
     */
    public void returnBook(Book book, Patron patron) {
        if (!books.contains(book)) {
            throw new IllegalArgumentException("Book not found in the library");
        }
        if (!patrons.contains(patron)) {
            throw new IllegalArgumentException("Patron not registered in the library");
        }
        if (!book.isCheckedOut()) {
            throw new IllegalStateException("Book is not checked out");
        }
        book.setCheckedOut(false);
        patron.removeCheckedOutBook(book);
    }

    /**
     * Gets the list of books in the library.
     *
     * @return The list of books in the library.
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * Gets the list of patrons registered in the library.
     *
     * @return The list of patrons registered in the library.
     */
    public List<Patron> getPatrons() {
        return patrons;
    }
}
