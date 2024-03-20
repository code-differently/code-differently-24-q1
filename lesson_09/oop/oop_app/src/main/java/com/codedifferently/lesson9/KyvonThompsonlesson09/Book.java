package com.codedifferently.lesson9.KyvonThompsonlesson09;


public class Book {
    // Book Characteristics 
    private Boolean checkedOut;
    private String authors;
    private String title;
    private int pageNumber;
    private float isbn; 

// Book Constructor
public Book(Boolean checkedOut, String authors, String title, int pageNumber, float isbn) {

    this.checkedOut = checkedOut;
    this.authors = authors;
    this.title = title;
    this.pageNumber = pageNumber;
    this.isbn = isbn;
    }

    //Getter for whether it was checked out
    public Boolean getCheckedOut() {
        return checkedOut;
    }

    //Setter for whether it was checked out
    public void setCheckedOut(Boolean checkedOut) {
        this.checkedOut = checkedOut;
     }
    
     // Getter for author(s) of the book
     public String getAuthors() {
        return authors;
     }
     
     //Setter for author(s) of the book
     public void setAuthors(String authors){
        this.authors = authors;
     }

     //Getter for book title
     public String getTitle() {
        return title;
     }

    //Setter for book title
     public void setTitle(String title) {
        this.title = title;
     }

     //Getter for the # of pages
     public int getPageNumber() {
        return pageNumber;
     }

     //Setter for the # of pages
     public void setPageNumbers(int pageNumber) {
        this.pageNumber = pageNumber;
     }

     //Getter for the isbn
     public float getIsbn() {
        return isbn;
     }

     //Setter for isbn
     public void setIsbn(float isbn) {
        this.isbn = isbn;
     }

    public boolean checkOut() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkOut'");
    }

    public void returnBook() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'returnBook'");
    }
}
