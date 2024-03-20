package com.codedifferently.lesson9;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson9.KyvonThompsonlesson09.Book;


public class Librarytest {
    @Test
     void main(String[] args) {
        // Creating books
        Book book1 = new Book(true, "Frank Miller", "The Dark Knight Returns", 250, 18.9595);
        Book book2 = new Book(false, "Scott Snyder", "Batman And Robin", 375, 12.4565);

        // Creating patrons
        Patron patron1 = new Patron("Bruce Wayne");
        Patron patron2 = new Patron("Dick Grayson");

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
