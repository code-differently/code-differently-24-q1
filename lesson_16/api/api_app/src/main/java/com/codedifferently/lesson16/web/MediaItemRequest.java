package com.codedifferently.lesson16.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaItemRequest {
  private String type;
  private String isbn;
  private String title;
  private String[] authors;
  private String edition;
  private int pages;
  private int runtime;
}
