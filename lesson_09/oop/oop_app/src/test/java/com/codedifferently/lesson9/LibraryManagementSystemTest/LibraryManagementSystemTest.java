package com.codedifferently.lesson9.LibraryManagementSystemTest;

import org.junit.jupiter.api.Test;

import com.codedifferently.lesson9.LibraryManagementSystem.Book;
import com.codedifferently.lesson9.LibraryManagementSystem.Library;


public class LibraryManagementSystemTest {

@Test
public void testAddBook() {
    Library library = new Library(); // create a new library
    
    String title = "The Pragmatic Programmer, 20th Anniversary Edition";
    String isbn = "9780135957059";
    String author = "David Thomas, Andrew Hunt";
    int pages = 320;

    Book book = new Book(title,isbn,author,pages); // create a new book

   
    library.addBook(book); // adds book to library
  
    /*  addBook() method will be defined in library class
        the logic inside addBook() will assign an element called book to a list
        In my test, I'll need a way to check if an element is present within a list using assertThat()
        
    */



}


}