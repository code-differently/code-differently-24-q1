package com.codedifferently.lesson9.natayaprice;

import java.util.HashMap;
import java.util.Map;

public class Patron {

  /**
   * Constructs a new Patron with the specified name and email.
   *
   * @param name the name of the patron
   * @param email the email of the patron
   */
  public Patron(String string, String string2) {
    // TODO Auto-generated constructor stub
  }

  /**
   * The main method to execute tests for Patron functionalities.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    testRegisterPatron();
    testPatronBooksCheckedOutMap();
  }

  /** Tests the registration of a patron with the library. */
  public static void testRegisterPatron() {
    Patron patron = new Patron("John Doe", "john@example.com");
    Library library = new Library();
    library.registerPatron(patron);
    System.out.println(
        library.getPatrons().contains(patron)
            ? "Patron should be registered with the library"
            : "Patron is not registered with the library");
  }

  /** Tests the patron-books checked out map. */
  public static void testPatronBooksCheckedOutMap() {
    Map<String, Integer> patronBooksCheckedOutMap = new HashMap<>();
    patronBooksCheckedOutMap.put("John Doe", 5);
    patronBooksCheckedOutMap.put("Jane Smith", 3);
    patronBooksCheckedOutMap.put("Alice Johnson", 0);

    System.out.println(
        patronBooksCheckedOutMap.get("John Doe") == 5
            ? "John Doe should have 5 books checked out"
            : "Incorrect number of books checked out for John Doe");
    System.out.println(
        patronBooksCheckedOutMap.get("Jane Smith") == 3
            ? "Jane Smith should have 3 books checked out"
            : "Incorrect number of books checked out for Jane Smith");
    System.out.println(
        patronBooksCheckedOutMap.get("Alice Johnson") == 0
            ? "Alice Johnson should have 0 books checked out"
            : "Incorrect number of books checked out for Alice Johnson");

    System.out.println(
        patronBooksCheckedOutMap.size() == 3
            ? "Size of the map is correct"
            : "Incorrect size of the map");

    patronBooksCheckedOutMap.put("John Doe", 8);
    System.out.println(
        patronBooksCheckedOutMap.get("John Doe") == 8
            ? "John Doe now has 8 books checked out"
            : "Incorrect number of books checked out for John Doe");

    System.out.println(
        patronBooksCheckedOutMap.get("Nonexistent Patron") == null
            ? "Nonexistent Patron is not found in the map"
            : "Nonexistent Patron is found in the map");
  }
}
