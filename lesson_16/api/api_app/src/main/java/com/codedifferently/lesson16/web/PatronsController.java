package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.Patron;
import com.codedifferently.lesson16.library.search.SearchCriteria;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import main.java.com.codedifferently.lesson16.web.CreatePatronResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatronsController {
  private final Library library;

  public PatronsController(Library library) throws IOException {
    this.library = library;
  }

  @GetMapping("/patrons")
  public ResponseEntity<List<Patron>> getPatrons(){
    Set<Patron> patronsSet = library.getAllPatrons();
    List<Patron> patronsList = new ArrayList<>(patronsSet);
    return new ResponseEntity<>(patronsList, HttpStatus.OK);
  }

  @GetMapping("/patron/{id}")
  public ResponseEntity<GetPatronsResponse> getPatron(@PathVariable("id") UUID id) {
    Patron patron = library.getPatronById(id);
    if (patron == null) {
      return ResponseEntity.notFound().build();
    }
    GetPatronsResponse response = GetPatronsResponse.from(patron);
    return ResponseEntity.ok(response);
  }

  @DeleteMapping("/patron/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public ResponseEntity<Void> deletePatron(@PathVariable("id") UUID id) {
    if (!library.hasPatron(id)) {
      return ResponseEntity.notFound().build();
    }
    library.removePatron(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/patron")
  @ResponseStatus(HttpStatus.CREATED)
  public CreatePatronResponse createPatron(@RequestBody CreatePatronRequest request) {
    Patron patron = request.getPatron();
    library.addPatron(patron);
    CreatePatronResponse response = CreatePatronResponse.from(patron);
    return response;
  }
}
