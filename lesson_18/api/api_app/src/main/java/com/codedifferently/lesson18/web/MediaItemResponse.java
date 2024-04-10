package com.codedifferently.lesson18.web;

import com.codedifferently.lesson18.library.Book;
import com.codedifferently.lesson18.library.MediaItem;
import com.codedifferently.lesson18.library.MediaType;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MediaItemResponse {
  private MediaType type;
  private UUID id;
  private String isbn;
  private String title;
  public List<String> authors;
  public String edition;
  public int pages;
  public int runtime;

  public static MediaItemResponse from(MediaItem item) {
    var result =
        MediaItemResponse.builder().id(item.getId()).title(item.getTitle()).type(item.getType());

    switch (item.getType()) {
      case BOOK -> {
        var book = (Book) item;
        result =
            result.isbn(book.getIsbn()).authors(book.getAuthors()).pages(book.getNumberOfPages());
      }
    }

    return result.build();
  }
}
