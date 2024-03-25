package main.java.com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.Library;
import com.codedifferently.lesson10.library.Patron;

import test.java.com.codedifferently.lesson10.library.Test;


 // Librarian Class
class Librarian {
    public void checkOutItem(Library library, MediaItem item, Patron patron) {
        library.checkOutItem(item, patron);
    }

    public void checkInItem(Library library, MediaItem item) {
        library.checkInItem(item);
    }
    // Method for the librarian to check in a book from a patron
    
    void checkInBook(Patron patron, Book book) {
        if (!book.isCheckedOut()) {
            System.out.println("The book \"" + book.getTitle() + "\" is not checked out.");
        } else if (!patron.getCheckedOutBooks().contains(book)) {
            System.out.println("The book \"" + book.getTitle() + "\" is not checked out by " + patron.getName());
        } else {
            book.setCheckedOut(false);
            patron.removeCheckedOutBook(book);
            System.out.println("Book \"" + book.getTitle() + "\" has been checked in by " + patron.getName());
        }
        // Method for the librarian to check out a book for a patron
   
    void checkOutBook(Patron patron, Book book) {
       if (book.isCheckedOut()) {
           System.out.println("Sorry, the book \"" + book.getTitle() + "\" is already checked out.");
       } else {
           book.setCheckedOut(true);
           patron.addCheckedOutBook(book);
           System.out.println("Book \"" + book.getTitle() + "\" has been checked out by " + patron.getName());
       }
   
}
}