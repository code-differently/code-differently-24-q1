package com.codedifferently.lesson16.web;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.MediaItem;
import com.codedifferently.lesson16.library.search.SearchCriteria;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.MediaItem;
import com.codedifferently.lesson16.library.search.SearchCriteria;

@RestController
public class MediaItemsController {
  private final Library library;
  private final Librarian librarian;

  public MediaItemsController(Library library) throws IOException {
    this.library = library;
    this.librarian = library.getLibrarians().stream().findFirst().orElseThrow();
  }

  @GetMapping("/items")
  public GetMediaItemsResponse getItems() {
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return response;
  }
  // the below methods are not mine. They were done in class by Jimira and Sherlin.  
  @DeleteMapping("/items/{id}") 
  public ResponseEntity<Void> deleteItem(@PathVariable("id") UUID id) {
    library.removeMediaItem(id, librarian);
    return ResponseEntity.noContent().build();
  }
  @PostMapping("/items")
  public CreateMediaItemResposne createItem(@requestBody CreateMediaItemRequest request) {
    MediaItem item = MediaItemRequest.asMediaItem(request.item);
  }
}
