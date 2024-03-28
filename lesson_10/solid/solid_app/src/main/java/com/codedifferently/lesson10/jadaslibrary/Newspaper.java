package com.codedifferently.lesson10.jadaslibrary;

public class Newspaper {
  private String title;
  private String publisher;
  private String publicationDate;

  public Newspaper(String title, String publisher, String publicationDate) {
    this.title = title;
    this.publisher = publisher;
    this.publicationDate = publicationDate;
  }

  // Getters and setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public String getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }
}
