package com.codedifferently.lesson7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;



// Design at least one custom class that represents a real-world object.
public class Book {

    // (Javyens comment) The extends keyword indicates that the class is inherited from the book class
    public static class NoBookAvailable extends Exception {
        public NoBookAvailable (string insertMessage) {
        }
    }

// The class must have at least 5 member variables of at least 3 different types.
    private string Title;
    private string Author; 
    private string Publisher;
    private short YearReleased;
    private float Price;  

// You must also incorporate an enum type as well.
    private enum Genre {
        NONFICTION, FICTION, HORROR, 
        MYSTERY, FANTASY, HISTORY;
    }

// The class must have at least one constructor.
public Book(string Title, string Author, string Publisher, short YearReleased, float Price) {
    this.Title = Title;
    this.Author = Author;
    this.Publisher = Publisher;
    this.YearReleased = YearReleased;
    this.Price = Price;
}

// The class must have at least 3 member functions. 
    public string getAuthor() {
        return Author;
    }

    public string getTitle() {
        return Title;
    }

    public string getPublisher() {
        return Publisher; 
    }

// One of your functions must make use of a conditional expression.
// One of your functions must make use of a loop.
// You must use at least one custom exception.

}