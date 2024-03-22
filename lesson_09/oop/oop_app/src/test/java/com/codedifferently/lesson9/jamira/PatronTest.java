package com.codedifferently.lesson9.jamira;

import java.util.ArrayList;
import java.util.List;

public class PatronTest {
  public static void main(String[] args) {
    // Create some sample data
    List<Book> checkedOutBooks = new ArrayList<>();
    checkedOutBooks.add(new Book("Title1", "ISBN1", List.of("Author1"), 100, true));
    checkedOutBooks.add(new Book("Title2", "ISBN2", List.of("Author2"), 150, true));

    // Create a patron object
    Patron patron = new Patron("John Doe", checkedOutBooks);

    // Test the getName() method
    System.out.println("Patron's name: " + patron.getName());

    // Test the getCheckedOutBooks() method
    System.out.println("Checked out books:");
    for (Book book : patron.getCheckedOutBooks()) {
      System.out.println(book.getTitle() + " - " + book.getIsbn());
    }

    // Test the addCheckedOutBook() method
    Book newBook = new Book("New Title", "New ISBN", List.of("New Author"), 200, true);
    patron.addCheckedOutBook(newBook);

    // Print the updated list of checked out books
    System.out.println("Updated checked out books:");
    for (Book book : patron.getCheckedOutBooks()) {
      System.out.println(book.getTitle() + " - " + book.getIsbn());
    }
  }
}
