package com.codedifferently.lesson16.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedifferently.lesson16.factory.LibraryDbDataLoader;
import com.codedifferently.lesson16.factory.LibraryFactory;
import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.MediaItem;
import com.codedifferently.lesson16.library.search.SearchCriteria;

@RestController
public class MediaItemsController {
  private final Library library;
  private final Librarian librarian;

  public MediaItemsController(LibraryDbDataLoader loader) throws IOException {
    this.library = LibraryFactory.createWithLoader(loader);
    this.librarian = this.library.getLibrarians().stream().findFirst().orElseThrow();
  }

  @GetMapping("/items")
  public GetMediaItemsResponse getItems() {
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    var response = GetMediaItemsResponse.builder().items(new ArrayList<>(items)).build();

    return response;
  }
}
