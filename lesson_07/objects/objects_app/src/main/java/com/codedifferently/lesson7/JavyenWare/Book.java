package com.codedifferently.lesson7;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;


// Design at least one custom class that represents a real-world object.
public class Book {

   // (Javyens comment) The extends keyword indicates that the class is inherited from the book class
   public static class NoBookAvailable extends Exception {
       public NoBookAvailable (string insertMessage) {
        super(insertMessage);
       }
   }


// The class must have at least 5 member variables of at least 3 different types.
   private string Title;
   private string Author;
   private string Publisher;
   private short YearReleased;
   private float Price; 
   private byte PageNumber;


// You must also incorporate an enum type as well.
   private enum Genre {
       NONFICTION, FICTION, HORROR,
       MYSTERY, FANTASY, HISTORY;
   }


// The class must have at least one constructor.
public Book(string Title, string Author, string Publisher, short YearReleased, float Price, byte PageNumber) {
   this.Title = Title;
   this.Author = Author;
   this.Publisher = Publisher;
   this.YearReleased = YearReleased;
   this.Price = Price;
   this.PageNumber = PageNumber;
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
    return PageNumber;
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
   public static void main(String[] args) {
    Book[] book = new Book[5];

    for (short i = 0; i < books.length; i++) {
      System.out.println("Books Published in" + getYearReleased);
    }
   }


// You must use at least one custom exception.

// My exception code starts on line 13.


}
