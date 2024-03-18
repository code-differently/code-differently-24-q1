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
    public NoBookAvailable (String insertMessage) {
     super(insertMessage);
    }
}


// The class must have at least 5 member variables of at least 3 different types.
   private String title;
   private String author;
   private String publisher;
   private Short yearReleased;
   private float price; 
   private byte pageNumber;


// You must also incorporate an enum type as well.
   private enum Genre {
       NONFICTION, 
       FICTION, 
       HORROR,
       MYSTERY, 
       FANTASY, 
       HISTORY;
   }


// The class must have at least one constructor.
public Book(String title, String author, String publisher, Short yearReleased, Float price, Byte pageNumber) {
   this.title = title;
   this.author = author;
   this.publisher = publisher;
   this.yearReleased = yearReleased;
   this.price = price;
   this.pageNumber = pageNumber;
}


// The class must have at least 3 member functions.
   public String getAuthor() {
       return author;
   }

   public String getTitle() {
       return title;
   }

   public String getPublisher() {
       return publisher;
   } 

   public Short getYearReleased() {
    return yearReleased;
   }

   public Float getPrice() {
    return price;
   } 
   public Byte getPageNumber() {
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
    CollectionOfAuthorNames[] authorNames =  authorNames[3];
    for (short i = 0; i < authorNames.length; i++) {
      System.out.println("Books Published in" + getYearReleased);
    }
   }


// You must use at least one custom exception.

// My exception code starts on line 13.


}
