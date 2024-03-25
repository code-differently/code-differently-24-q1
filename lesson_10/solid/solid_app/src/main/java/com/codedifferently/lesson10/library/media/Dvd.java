package com.codedifferently.lesson10.library.media;

public class Dvd {
  private String title;
  private String director;
  private int duration;

  public Dvd(String title, String director, int duration) {
    this.title = title;
    this.director = director;
    this.duration = duration;
  }

  public String getTitle() {
    return title;
  }

  public String getDirector() {
    return director;
  }

  public int getDuration() {
    return duration;
  }
}
