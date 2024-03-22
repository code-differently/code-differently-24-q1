package com.codedifferently.lesson9.natayaprice;

public class Book {
  
private String Titles;
private int ISBN;
private String Authors;
private int TotalPages;
private boolean CheckedOut;


public Book(String Titles, int ISBN, String Authors, int TotalPages,boolean CheckedOut) {
this.Titles = Titles;
this.ISBN = ISBN;
this.Authors = Authors;
this.TotalPages = TotalPages;
this.CheckedOut = CheckedOut;
}


public String getTitles() {
 return Titles;
}

public int getISBN() {
    return ISBN;
}
   
public String getAuthors() {
    return Authors;
}

public int getTotalPages() {
    return TotalPages;
}

public boolean getCheckedOut() {
    return CheckedOut;
}
}
