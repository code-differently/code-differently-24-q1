package com.codedifferently.lesson9.randycastro;

public class Book {

        private String title;
        private String isbn;
        private String author;
        private int page;
        private boolean checkedOut;
    
        // constructor for Book
        public Book(String title, String isbn, String author, int page, boolean checkedOut) {
          this.title = title;
          this.isbn = isbn;
          this.author = author;
          this.page = page;
          this.checkedOut = checkedOut;
        }
         // Getters and Setters

    public String getTitle() {
        return title;
      }
  
      public String getIsbn() {
        return isbn;
      }
  
      public String getAuthor() {
        return author;
      }
  
      public int getPage() {
        return page;
      }

      public boolean getCheckedout() {
        return checkedOut;
      }

      
        Book book1 = new Book("The Software Engineer Guidebook","12345e","Gergely Orosz",405,false);{
      
        System.out.println("Book title: " + book1.getTitle());
      }
      Book book2 = new Book("Code Complete", "9788178530857","Steve McConnel", 960, false);{
        System.out.println("Book title: " + book2.getTitle());
      }
 Book book3 = new Book("Cracking the coding interview","9780984782871","Gayle Laakmann McDowell", 700, false); {
  System.out.println("Book title: " + book3.getTitle());
 }




    }
