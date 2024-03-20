package com.codedifferently.lesson9.LibraryManagementSystem;

/**
 * Represents a book in the library.
 */
public class Book {
    private String title;
    private String author;
    private String isbn;
    private int numberOfPages;
    private boolean checkedOut;

    /**
     * Constructs a new Book instance with the given parameters.
     *
     * @param title         The title of the book.
     * @param isbn          The ISBN of the book.
     * @param author        The author(s) of the book.
     * @param numberOfPages The number of pages in the book.
     */
    public Book(String title, String isbn, String author, int numberOfPages) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.checkedOut = false; // Initially, the book is not checked out
    }

    /**
     * Gets the author(s) of the book.
     *
     * @return The author(s) of the book.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the author(s) of the book.
     *
     * @param author The author(s) of the book.
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn The ISBN of the book.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Gets the number of pages in the book.
     *
     * @return The number of pages in the book.
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Sets the number of pages in the book.
     *
     * @param numberOfPages The number of pages in the book.
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    /**
     * Gets the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title The title of the book.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Checks if the book is currently checked out.
     *
     * @return True if the book is checked out, false otherwise.
     */
    public boolean isCheckedOut() {
        return checkedOut;
    }

    /**
     * Sets the checked out status of the book.
     *
     * @param checkedOut True if the book is to be checked out, false otherwise.
     */
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}
