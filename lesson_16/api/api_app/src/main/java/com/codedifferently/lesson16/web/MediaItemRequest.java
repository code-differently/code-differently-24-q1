package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.MediaType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaItemRequest {
  private MediaType type;
  private String isbn;
  private String title;
  private String[] authors;
  private String edition;
  private int pages;
  private int runtime;
}
