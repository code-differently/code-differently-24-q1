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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
>>>>>>> bd837e4 (feat: Implement MediaItemsController and PatronsController)
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author vscode
 */
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

  @PostMapping("/items")
  public CreateMediaItemResponse postItem(@Valid @RequestBody CreateMediaItemRequest request) {
    MediaItem item = MediaItemRequest.asMediaItem(request.getItem());
    library.addMediaItem(item, librarian);
    var response = CreateMediaItemResponse.builder().item(MediaItemResponse.from(item)).build();
    return response;
  }

  @GetMapping("/items/{id}")
  public GetMediaItemsResponse getMediaItem(@PathVariable String id) {
    Set<MediaItem> items = library.search(SearchCriteria.builder().id(id).build());
    if (items.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Media item not found");
    }
    List<MediaItemResponse> responseItems = items.stream().map(MediaItemResponse::from).toList();
    var response = GetMediaItemsResponse.builder().items(responseItems).build();
    return response;
  }

  @DeleteMapping("/items/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable("id") UUID id) {
    if (!library.hasMediaItem(id)) {
      return ResponseEntity.notFound().build();
    }
    try {
      library.removeMediaItem(id, new Librarian("Default", "librarian@example.com"));
      return ResponseEntity.noContent().build();
    } catch (MediaItemCheckedOutException e) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST, "Cannot delete checked out item", e);
    }
  }
}
