package com.codedifferently.lesson16.web;

import java.io.IOException;
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

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.Patron;

import jakarta.validation.Valid;

@RestController
public class PatronsController {
  private final Library library;

  public PatronsController(Library library) throws IOException {
    this.library = library;
  }

  // Mohamed helped me sort out this method!
  @GetMapping("/patrons")
  public GetPatronsResponse getPatrons() {
    Set<LibraryGuest> patrons = library.getPatrons();
    List<PatronResponse> responsePatrons = patrons.stream().map(PatronResponse::from).toList();
    var response = GetPatronsResponse.builder().patrons(responsePatrons).build();
    return response;
  }

  @PostMapping("/patrons")
  public CreatePatronResponse postPatron(@Valid @RequestBody CreatePatronRequest request) {
    Patron patron = PatronRequest.asPatron(request.getPatron());
    library.addLibraryGuest(patron);
    var response = CreatePatronResponse.builder().patron(PatronResponse.from(patron)).build();
    return response;
  }

  @GetMapping("/patrons/{id}")
public GetPatronsResponse getPatronById(@PathVariable UUID id) {
    for (LibraryGuest patron : library.getPatrons()) {
        if (patron.getId().equals(id)) {
            return GetPatronsResponse.builder().patron(PatronResponse.from(patron)).build();
        }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron not found");
}

  @DeleteMapping("/patrons/{id}")
  public ResponseEntity<Void> deleteItem(@PathVariable String id) {
    if (!library.hasLibraryGuest(UUID.fromString(id))) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patron not found");
    }

    library.removeLibraryGuest(UUID.fromString(id));
    return ResponseEntity.noContent().build();
  }
}
