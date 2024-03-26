package com.codedifferently.lesson10.library.media;

import com.codedifferently.lesson10.library.Book;
import java.util.List;

public class Dvd extends Book {
  public Dvd(String id, String title, List<String> authors, int year) {
    super(id, title, authors, year); // Updated constructor call with four arguments
  }

}
