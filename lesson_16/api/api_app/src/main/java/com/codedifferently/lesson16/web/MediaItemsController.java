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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

// ___________________________________________________________
// THIS CODE WAS MADE IN COLLABORATION WITH VICENTE AND RICH
// ___________________________________________________________

@RestController
@CrossOrigin
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

  /**
   * Post an item to the specified endpoint.
   *
   * @param req the request object for creating a media item
   * @return the response object for creating a media item
   */
  @PostMapping("/items")
  public CreateMediaItemResponse postItem(@Valid @RequestBody CreateMediaItemRequest req) {
    MediaItem media = MediaItemRequest.asMediaItem(req.getItem());
    library.addMediaItem(media, librarian);
    return CreateMediaItemResponse.builder().item(MediaItemResponse.from(media)).build();
  }

  @GetMapping("/items/{id}")
  public GetMediaItemsResponse getItem(@PathVariable UUID id) {
    Set<MediaItem> items = library.search(SearchCriteria.builder().id(id.toString()).build());
    if (items.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Media item not found");
    }
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return response;
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
    if (!library.hasMediaItem(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Media item not found");
    }
    library.removeMediaItem(id, librarian);
    return ResponseEntity.noContent().build();
  }
}
