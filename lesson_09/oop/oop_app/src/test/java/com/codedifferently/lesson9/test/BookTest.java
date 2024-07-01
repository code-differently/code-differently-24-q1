package com.codedifferently.lesson9.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson9.library.Book;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BookTest {

  @Test
  public void testComicConstructor() {
    List<String> authors = new ArrayList<>();
    authors.add("Stan Lee");
    Book comic = new Book("Spider-Man", "9781302920528", authors, 200);
    assertEquals("Spider-Man", comic.getTitle());
    assertEquals("9781302920528", comic.getIsbn());
    assertEquals(authors, comic.getAuthors());
    assertEquals(200, comic.getNumPages());
    assertFalse(comic.isCheckedOut());
  }

  @Test
  public void testSetCheckedOut() {
    Book comic = new Book("Iron Man", "9781302921556", List.of("Stan Lee"), 150);
    assertFalse(comic.isCheckedOut());
    comic.setCheckedOut(true);
    assertTrue(comic.isCheckedOut());
  }
}
