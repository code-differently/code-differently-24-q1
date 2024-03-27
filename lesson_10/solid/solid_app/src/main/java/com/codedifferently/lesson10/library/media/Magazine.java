package com.codedifferently.lesson10.library.media;

public class Magazine {
  private String title;
  private String issueNumber;
  private String publicationDate;

  public Magazine(String title, String issueNumber, String publicationDate) {
    this.title = title;
    this.issueNumber = issueNumber;
    this.publicationDate = publicationDate;
  }

  public String getTitle() {
    return title;
  }

  public String getIssueNumber() {
    return issueNumber;
  }

  public String getPublicationDate() {
    return publicationDate;
  }
}
