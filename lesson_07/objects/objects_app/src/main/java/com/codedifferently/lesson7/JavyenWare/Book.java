package com.codedifferently.lesson7.javyenware;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


/** Design at least one custom class that represents a real-world object.
**(javy/W comment) A class is a blueprint or template for creating something 
*/ 
public class Book {

// (javy/W comment) The extends keyword indicates that the class is inherited from the book class
public static class NoBookAvailable extends Exception {
    public NoBookAvailable (string insertMessage) {
     super(insertMessage);
    }
}


// The class must have at least 5 member variables of at least 3 different types.
   private string title;
   private string author;
   private string publisher;
   private short yearReleased;
   private float price; 
   private byte pageNumber;


// You must also incorporate an enum type as well.
   private enum Genre {
       NONFICTION, FICTION, HORROR,
       MYSTERY, FANTASY, HISTORY;
   }


// The class must have at least one constructor.
public Book(string title, string author, string publisher, short yearReleased, float price, byte pageNumber) {
   this.Title = title;
   this.Author = author;
   this.Publisher = publisher;
   this.YearReleased = yearReleased;
   this.Price = price;
   this.PageNumber = pageNumber;
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

   public short getYearReleased() {
    return YearReleased;
   }

   public float getPrice() {
    return Price;
   } 
   public byte getPageNumber() {
    return pageNumber;
   }


// One of your functions must make use of a conditional expression.
   public static void price(float price){
    if (price >= 15.00) {
    System.out.println("Don't buy book (Too expensive)");
    } else {
        System.out.println("Buy the book (Good price to buy)");
    }
}


// One of your functions must make use of a loop.
   public static void CollectionOfAuthorNames(String[] args) {
    authorNames[] authorNames =  authorNames[3];
    for (short i = 0; i < authorNames.length; i++) {
      System.out.println("Books Published in" + getYearReleased);
    }
   }


// You must use at least one custom exception.

// My exception code starts on line 13.


}
