package com.codedifferently.lesson9.randycastro;
import com.codedifferently.lesson9.randycastro.librarytest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class librarytest {
    @Test
    public void testGetBookByISBN(){
        com.codedifferently.lesson9.randycastro.library library = new library ();

        Book retrievedBook1 = library.getBookByISBN ( "12345e");
    }

    }

 // Testing library
 //Arrange


 //Act





 //Assert


