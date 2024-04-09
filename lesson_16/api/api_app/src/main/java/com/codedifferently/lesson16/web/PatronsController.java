package com.codedifferently.lesson16.web;

 import com.codedifferently.lesson16.library.Librarian;
 import com.codedifferently.lesson16.library.Library;
 import com.codedifferently.lesson16.library.Patron;
 import com.codedifferently.lesson16.library.search.PatronSearchCriteria;
 import java.io.IOException;
 import java.util.List;
 import java.util.Set;
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
   public ResponseEntity<GetPatronsResponse> getPatrons() {
    Set<Patron> patrons = library.searchPatrons(PatronSearchCriteria.builder().build());
     List<PatronResponse> responsePatrons = PatronResponse.from(patrons);
     return ResponseEntity.ok(GetPatronsResponse.builder().patrons(responsePatrons).build());
   }

  @PostMapping("/patrons")
  public ResponseEntity<AddPatronResponse> addPatron(@RequestBody PatronRequest patronRequest) {
     Patron patron = PatronRequest.toPatron(patronRequest);
     library.add(patron, librarian);
     return ResponseEntity.status(HttpStatus.CREATED).body(AddPatronResponse.from(patron));
   }

   @GetMapping("/patrons/{id}")
  public ResponseEntity<PatronResponse> getPatron(@PathVariable String id) {
    Patron patron = library.findPatronById(id);
    if (patron == null) {
       return ResponseEntity.notFound().build();
     }
     return ResponseEntity.ok(PatronResponse.from(patron));
   }

   @DeleteMapping("/patrons/{id}")
   public ResponseEntity<Void> deletePatron(@PathVariable String id) {
     Patron patron = library.findPatronById(id);
     if (patron == null) {
      return ResponseEntity.notFound().build();
     }
     library.remove(patron, librarian);
    return ResponseEntity.noContent().build();
   }
 }
