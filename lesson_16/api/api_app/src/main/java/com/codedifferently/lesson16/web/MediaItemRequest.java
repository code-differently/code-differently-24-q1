package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.MediaType;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MediaItemRequest {
  @NotBlank(message = "Type is required")
  private MediaType type;

  private String isbn;

  @NotBlank(message = "Title is required")
  private String title;

  private String[] authors;
  private String edition;
  private int pages;
  private int runtime;
}
