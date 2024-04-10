package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Librarian;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.Patron;
import com.codedifferently.lesson16.library.search.PatronSearchCriteria;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatronsController {
  private final Library library;
  private final Librarian librarian;

  public PatronsController(Library library) throws IOException {
    this.library = library;
    this.librarian = library.getLibrarians().stream().findFirst().orElseThrow();
  }

  @GetMapping("/patrons")
 public ResponseEntity<List<Patron>> getPatrons() {
    Set<LibraryGuest> guests = library.getPatrons();
    List<Patron> patrons = new ArrayList<>(guests);
    return ResponseEntity.ok(patrons);
}


  @PostMapping("/patrons")
  public ResponseEntity<GetPatronResponse> addPatron(@RequestBody PatronRequest patronRequest) {
    Patron patron = PatronRequest.toPatron(patronRequest);
    library.addLibraryGuest(patron);
    return ResponseEntity.status(HttpStatus.CREATED).body(GetPatronResponse.from(patron));
  }

  @GetMapping("/patrons/{id}")
  public ResponseEntity<PatronResponse> getPatron(@PathVariable UUID id) {
    Patron patron = library.getPatrons(id);
    if (patron == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(PatronResponse.from(patron));
  }

  @DeleteMapping("/patrons/{id}")
  public ResponseEntity<Void> deletePatron(@PathVariable UUID id) {
    Patron patron = library.getPatrons(id);
    if (patron == null) {
      return ResponseEntity.notFound().build();
    }
    library.removeLibraryGuest(patron);
    return ResponseEntity.noContent().build();
  }
}
