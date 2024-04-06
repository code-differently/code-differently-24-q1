package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.MediaItem;
import com.codedifferently.lesson16.library.exceptions.MediaItemCheckedOutException;
import com.codedifferently.lesson16.library.search.SearchCriteria;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/items")
  public CreateMediaItemResponse createItem(@Valid @RequestBody CreateMediaItemRequest request) {
    MediaItem item = MediaItemRequest.asMediaItem(request.getItem());
    library.addMediaItem(item, librarian);
    return CreateMediaItemResponse.builder().item(MediaItemResponse.from(item)).build();
  }

  @GetMapping("/items/{id}")
  public ResponseEntity<MediaItemResponse> getMediaItem(@PathVariable UUID id) {
    SearchCriteria criteria = SearchCriteria.builder().id(id.toString()).build();
    Set<MediaItem> items = library.search(criteria);
    if (!items.isEmpty()) {
      MediaItemResponse response = MediaItemResponse.from(items.iterator().next());
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
    SearchCriteria criteria = SearchCriteria.builder().id(id.toString()).build();
    Set<MediaItem> items = library.search(criteria);
    if (!items.isEmpty()) {
      try {
        library.removeMediaItem(id, new Librarian("Default", "librarian@example.com"));
        return ResponseEntity.noContent().build();
      } catch (MediaItemCheckedOutException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
      }
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
