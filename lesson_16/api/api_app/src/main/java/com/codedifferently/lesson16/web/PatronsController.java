package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.exceptions.MediaItemCheckedOutException;
import jakarta.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patrons")
public class PatronsController {

  private final Library library;
  private final Map<UUID, LibraryGuest> patronMap;

  public PatronsController(Library library) {
    this.library = library;
    this.patronMap = new HashMap<>();
  }

  @GetMapping("/patrons")
  public ResponseEntity<Collection<LibraryGuest>> getPatrons() {
    Collection<LibraryGuest> patrons = library.getPatrons();
    return ResponseEntity.ok(patrons);
  }

  @PostMapping("/patrons")
  public ResponseEntity<Void> createPatron(@Valid @RequestBody PatronsRequest request) {
    LibraryGuest guest = PatronsRequest.asLibraryGuest(request);
    library.addLibraryGuest(guest);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/{id}")
  public ResponseEntity<LibraryGuest> getPatronById(@PathVariable UUID id) {
    LibraryGuest patron = patronMap.get(id);
    if (patron != null) {
      return ResponseEntity.ok(patron);
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
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
