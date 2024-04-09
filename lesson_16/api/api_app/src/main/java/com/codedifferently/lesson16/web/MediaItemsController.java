package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.MediaItem;
import com.codedifferently.lesson16.library.search.SearchCriteria;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MediaItemsController {
  private final Library library;
  private final Librarian librarian;

  public MediaItemsController(Library library) throws IOException {
    this.library = library;
    this.librarian = library.getLibrarians().stream().findFirst().orElseThrow();
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<GetMediaItemsResponse> getItem(@PathVariable("id") UUID id) {
    if (!library.hasMediaItem(id)) {
      return ResponseEntity.notFound().build(); // Return 404 Not Found
    }
    Set<MediaItem> items = library.search(SearchCriteria.builder().build());
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/items")
  public ResponseEntity<GetMediaItemsResponse> getItems() {
    try {
      Set<MediaItem> items = library.search(SearchCriteria.builder().build());
      List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
      var response = GetMediaItemsResponse.builder().items(responseItems).build();
      return ResponseEntity.ok(response);
    } catch (Exception ex) {
      // Log the exception for debugging purposes
      ex.printStackTrace();
      // Return an appropriate error response
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/items/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deleteItem(@PathVariable("id") UUID id) {
    if (!library.hasMediaItem(id)) {
      return ResponseEntity.notFound().build();
    }
    library.removeMediaItem(id, librarian);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/items")
  public CreateMediaItemResponse createItem(@Valid @RequestBody CreateMediaItemRequest request) {
    MediaItem item = MediaItemRequest.asMediaItem(request.getItem());
    library.addMediaItem(item, librarian);
    var response = CreateMediaItemResponse.builder().item(MediaItemResponse.from(item)).build();

    return response;
  }
}
