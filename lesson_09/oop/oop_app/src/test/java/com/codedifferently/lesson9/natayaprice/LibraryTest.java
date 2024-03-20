package com.codedifferently.lesson9.natayaprice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
    void testLibraryConstruction() {
        Library library = new Library();
    }   

    @Test
    void testAddBook() {
    Book book = new Book("781250170972", "Children of Blood and Bone", "Tomi Adeyemi",544); 
    Library.addBook(book);    
    assertTrue(yourLibrary.hasBook("781250170972"));
    Book retrievedBook = yourLibrary.getBook("781250170972");
    assertEquals(book, retrievedBook);
}
    @Test
    void testRemoveBook() {
    Book book = new Book("9780810970571", "The Sisters Grimm:The Fairy-Tale Detectives", "Michael Buckley",176);
    yourLibrary.addBook(book);
    assertTrue(yourLibrary.hasBook("9780810970571"));
    yourLibrary.removeBook("9780810970571");
    assertFalse(yourLibrary.hasBook("9780810970571"));
 }   
}
