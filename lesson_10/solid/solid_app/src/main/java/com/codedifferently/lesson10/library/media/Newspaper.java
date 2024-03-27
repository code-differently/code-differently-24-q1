package com.codedifferently.lesson10.library.media;

public class Newspaper {
  private String title;
  private String edition;
  private String publicationDate;

  public Newspaper(String title, String edition, String publicationDate) {
    this.title = title;
    this.edition = edition;
    this.publicationDate = publicationDate;
  }

  public String getTitle() {
    return title;
  }

  public String getEdition() {
    return edition;
  }

  public String getPublicationDate() {
    return publicationDate;
  }
}
