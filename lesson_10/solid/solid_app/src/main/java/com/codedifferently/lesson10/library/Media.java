package com.codedifferently.lesson10.library;

import java.util.List;


public interface Media {
String getTitle();
boolean isCheckedOut();
void checkOut( Librarian librarian);
void returnItem();
}
// Dvd class

public class Dvd implements Media {

  private String title;
  private String director;
  private boolean checkedOut;

public Dvd (String title, String director) {

  this.title = title;
  this.director = director;
  this.checkedOut = false;
}

@Override

public String getTitle(){
return title;
}
public String getDirector(){
  return director;
}
public boolean isCheckedOut(){
  return checkedOut;
}

@Override
public boolean checkedOut (Librarian librarian) {

    if (librarian = !null) {
        checkedOut = true;
        return true;
}
else { 
   System.out.println("A librarian must be present to check out the Dvd.");
  return false;
}
}

// Book class

public class Book implements Media {
  private Library library;
  private String title;
  private String isbn;
  private List<String> authors;
  private int numberOfPages;
  private boolean checkedOut;

  public Book(String title, String isbn, List<String> authors, int numberOfPages) {
      this.title = title;
      this.isbn = isbn;
      this.authors = authors;
      this.numberOfPages = numberOfPages;
      this.checkedOut = false;
  }

  @Override
  public String getTitle() {
      return title;
  }

  @Override
  public boolean isCheckedOut() {
      return checkedOut;
  }

  @Override
  public void checkOut(Librarian librarian) {
      // Implement logic to check out the book if librarian is present
      if (librarian != null) {
          checkedOut = true;
      } else {
          System.out.println("A librarian must be present to check out the book.");
      }
  }

  @Override
  public void returnItem() {
      checkedOut = false;
  }
}
}





