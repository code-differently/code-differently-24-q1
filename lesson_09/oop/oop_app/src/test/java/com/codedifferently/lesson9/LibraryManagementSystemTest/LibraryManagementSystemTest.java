package com.codedifferently.lesson9.LibraryManagementSystemTest;

import org.junit.jupiter.api.Test;


public class LibraryManagementSystemTest {

@Test
public void testAddBook() {
    Library library = new library(); // create a new library
    Book book = new book(title,isbn,numberofpages,author); // create a new book

    library.addBook(book); // adds book to library
  
    /*  addBook() method will be defined in library class
        the logic inside addBook() will assign an element called book to a list
        In my test, I'll need a way to check if an element is present within a list using assertThat()
        
    */

    assertThat  

}


}