package com.codedifferently.lesson12.models;

import java.util.List;
import java.util.UUID;

public class MediaItemModel {
  public String type;
  public UUID id;
  public String isbn;
  public String title;
  public List<String> authors;
  public String edition;
  public int pages;
  public int runtime;
}
