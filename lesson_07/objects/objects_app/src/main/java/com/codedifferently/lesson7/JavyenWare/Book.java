package com.codedifferently.lesson7.javyenware;


public class Book {

    public static class NoBookAvailable extends Exception {
        public NoBookAvailable(String insertMessage) {
            super(insertMessage);
        }
    }

    private String title;
    private String author;
    private String publisher;
    private Short yearReleased;
    private float price;
    private byte pageNumber;

    private enum BookGenre {
        NONFICTION,
        FICTION,
        HORROR,
        MYSTERY,
        FANTASY,
        HISTORY;
    }

    public Book(String title, String author, String publisher, Short yearReleased, Float price, Byte pageNumber) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearReleased = yearReleased;
        this.price = price;
        this.pageNumber = pageNumber;
    }

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

    public String price(float price) {
        if (price >= 15.00) {
            return "Don't buy book (Too expensive)";
        } else {
            return "Buy the book (Good price to buy)";
        }
    }

    public void CollectionOfAuthorNames(String[] args) {
        // Assuming this method collects author names and years of publication and prints them
        // Here, we'll just test if the method doesn't throw any exceptions.
        // CollectionOfAuthorNames[] authorNames =  authorNames[3];
        for (short i = 0; i < args.length; i++) {
            System.out.println("Books Published in" + getYearReleased());
        }
    } 

    // The code below 
    public static void main(String[] args) {
        // Example usage of the BookGenre enum
        BookGenre genre = BookGenre.FICTION;
        System.out.println("Selected genre: " + genre);
    }

}
