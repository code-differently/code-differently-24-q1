package com.codedifferently.lesson9.natayaprice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class PatronTest {

  /** Tests the registration of a patron with the library. */
  @Test
  public void testRegisterPatron() {
    Patron patron = new Patron("John Doe", "john@example.com");
    Library library = new Library();
    library.registerPatron(patron);
    assertTrue(
        library.getPatrons().contains(patron), "Patron should be registered with the library");
  }

  /** Tests the patron-books checked out map. */
  @Test
  public void testPatronBooksCheckedOutMap() {

    Map<String, Integer> patronBooksCheckedOutMap = new HashMap<>();
    patronBooksCheckedOutMap.put("John Doe", 5);
    patronBooksCheckedOutMap.put("Jane Smith", 3);
    patronBooksCheckedOutMap.put("Alice Johnson", 0);

    assertEquals(5, patronBooksCheckedOutMap.get("John Doe").intValue());
    assertEquals(3, patronBooksCheckedOutMap.get("Jane Smith").intValue());
    assertEquals(0, patronBooksCheckedOutMap.get("Alice Johnson").intValue());

    assertEquals(3, patronBooksCheckedOutMap.size());

    patronBooksCheckedOutMap.put("John Doe", 8);
    assertEquals(8, patronBooksCheckedOutMap.get("John Doe").intValue());

    assertNull(patronBooksCheckedOutMap.get("Nonexistent Patron"));
  }
}
