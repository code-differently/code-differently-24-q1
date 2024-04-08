package mcom.codedifferently.lesson16.web;

import java.io.IOException;
import java.util.Collection;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PatronsController {
    private final com.codedifferently.lesson16.library.Library library;
    
    public PatronsController(Library library) throws IOException {
        this.library = library;
    }

    // get list of patrons 
    @GetMapping("list of patrons")
    public Collection<getListOfPatrons> getPatrons() {
        return library.getPatrons();
    }

    @DeleteMapping("")
    public static {
        
    }

    @PostMapping("")
    public void createPatron(@Valid @RequestBody PatronsRequest request) {
        LibraryGuest guest = PatronsRequest.asLibraryGuest(request);
        library.addLibraryGuest(guest);
    }
}
