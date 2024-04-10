package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.Patron;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class PatronsController {
  private final Library library;

  public PatronsController(Library library) throws IOException {
    this.library = library;
  }

  @GetMapping("/patrons")
  public GetPatronsResponse getPatrons() {
    Set<LibraryGuest> patrons = library.getPatrons();
    List<PatronResponse> responsePatrons = patrons.stream().map(PatronResponse::from).toList();
    var response = GetPatronsResponse.builder().patrons(responsePatrons).build();
    return response;
  }

  @PostMapping("/patrons")
  public CreatePatronResponse postPatron(@Valid @RequestBody CreatePatronRequest req) {
    Patron guest = PatronRequest.asPatron(req.getPatron());
    library.addLibraryGuest(guest);
    return CreatePatronResponse.builder().patron(PatronResponse.from(guest)).build();
  }

  @GetMapping("/patrons/{id}")
  public GetPatronsResponse getPatron(@PathVariable("id") UUID id) {
    if (!library.hasLibraryGuest(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest patron not found");
    }
    Set<LibraryGuest> patrons = new HashSet<>();
    for (LibraryGuest guest : library.getPatrons()) {
      if (guest.getId() == id) {
        patrons.add(guest);
      }
    }
    List<PatronResponse> responsePatrons = patrons.stream().map(PatronResponse::from).toList();
    var response = GetPatronsResponse.builder().patrons(responsePatrons).build();
    return response;
  }

  @DeleteMapping("/patrons/{id}")
  public ResponseEntity<Void> deletePatron(@PathVariable() UUID id) {
    if (!library.hasLibraryGuest(id)) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Guest patron not found");
    }
    library.removeLibraryGuest(id);
    return ResponseEntity.noContent().build();
  }
}
