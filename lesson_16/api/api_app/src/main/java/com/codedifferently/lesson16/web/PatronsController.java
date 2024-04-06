package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.exceptions.MediaItemCheckedOutException;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.UUID;
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
  public ResponseEntity<?> createPatron(@Valid @RequestBody PatronsRequest request) {
    LibraryGuest guest = PatronsRequest.asLibraryGuest(request);
    library.addLibraryGuest(guest);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Collection<LibraryGuest>> getPatron() {
    Collection<LibraryGuest> patron = library.getPatrons();
    return ResponseEntity.ok(patron);
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
