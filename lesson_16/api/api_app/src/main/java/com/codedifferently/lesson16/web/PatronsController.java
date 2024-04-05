package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.exceptions.MediaItemCheckedOutException;
import com.codedifferently.lesson16.library.search.SearchCriteria;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrons")
public class PatronsController {

  private final Library library;

  public PatronsController(Library library) {
    this.library = library;
  }

  @GetMapping
  public ResponseEntity<Collection<LibraryGuest>> getPatrons() {
    Collection<LibraryGuest> patrons = library.getPatrons();
    return ResponseEntity.ok(patrons);
  }

  @PostMapping
  public ResponseEntity<?> createPatron(@RequestBody LibraryGuest patron) {
    library.addLibraryGuest(patron);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<LibraryGuest> getPatron(@PathVariable UUID id) {
    SearchCriteria query = SearchCriteria.builder().id(id.toString()).build();
    Collection<LibraryGuest> patrons =
        library.search(query).stream()
            .filter(item -> item instanceof LibraryGuest)
            .map(item -> (LibraryGuest) item)
            .collect(Collectors.toList());
    if (!patrons.isEmpty()) {
      return ResponseEntity.ok(patrons.iterator().next());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removePatron(@PathVariable UUID id) {
    try {
      library.removeLibraryGuest(id);
      return ResponseEntity.noContent().build();
    } catch (MediaItemCheckedOutException e) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
  }
}
