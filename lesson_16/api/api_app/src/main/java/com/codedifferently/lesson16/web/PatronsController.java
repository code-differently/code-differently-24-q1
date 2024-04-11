package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatronsController {

  private final Library library;

  public PatronsController(Library library) throws IOException {
    this.library = library;
  }

  @GetMapping("/patrons")
  public GetPatronsResponse getAllPatrons() {
    Set<LibraryGuest> patrons = library.getPatrons();
    List<PatronsResponse> responseItems =
        patrons.stream().map(PatronsResponse::from).collect(Collectors.toList());
    return GetPatronsResponse.builder().patrons(responseItems).build();
  }

  @GetMapping("/patrons/{id}")
  public ResponseEntity<PatronsResponse> getPatronbyId(@PathVariable UUID id) {
    Set<LibraryGuest> patrons = library.getPatrons();

    if (!patrons.isEmpty()) {
      LibraryGuest patron = patrons.iterator().next();
      PatronsResponse response = PatronsResponse.from(patron);
      return ResponseEntity.ok(response);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("/patrons")
  public CreatePatronsResponse createPatron(@Valid @RequestBody CreatePatronsRequest request) {
    LibraryGuest patron = PatronsRequest.asLibraryGuest(request.getPatron());
    library.addLibraryGuest(patron);
    return CreatePatronsResponse.builder().patron(PatronsResponse.from(patron)).build();
  }

  @DeleteMapping("/patrons/{id}")
  public ResponseEntity<Void> deletePatron(@PathVariable("id") UUID id) {
    try {
      library.removeLibraryGuest(id);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
