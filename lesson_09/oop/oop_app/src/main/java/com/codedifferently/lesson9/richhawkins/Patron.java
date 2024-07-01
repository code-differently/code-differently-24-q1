package main.java.com.codedifferently.lesson9.richhawkins;

import java.util.HashSet;

public class Patron {
  private String name;
  private HashSet<String> checkedOutBooks = new HashSet<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HashSet<String> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void setCheckedOutBooks(HashSet<String> checkedOutBooks) {
    this.checkedOutBooks = checkedOutBooks;
  }

  public Patron(String name) {
    this.name = name;
  }
}
