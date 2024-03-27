package com.codedifferently.lesson10.jadaslibrary;

public class Magazine extends MediaItem {
  private String title;
  private String publisher;
  private int issueNumber;

  public Magazine(String title, String isbn, String publisher, int numberOfPages, int issueNumber) {
    super(title, isbn, numberOfPages);
    this.title = title;
    this.publisher = publisher;
    this.issueNumber = issueNumber;
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

  public int getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(int issueNumber) {
    this.issueNumber = issueNumber;
  }
}
