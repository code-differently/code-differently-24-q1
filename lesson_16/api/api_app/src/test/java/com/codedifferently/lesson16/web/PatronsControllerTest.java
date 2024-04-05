import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.exceptions.MediaItemCheckedOutException;
import com.codedifferently.lesson16.web.PatronsController;
import java.util.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PatronsControllerTest {

  @Mock private Library library;

  @InjectMocks private PatronsController patronsController;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testGetPatrons() {
    LibraryGuest patron1 = mock(LibraryGuest.class);
    LibraryGuest patron2 = mock(LibraryGuest.class);
    Set<LibraryGuest> patrons = new HashSet<>(Arrays.asList(patron1, patron2));
    when(library.getPatrons()).thenReturn(patrons);

    ResponseEntity<Collection<LibraryGuest>> response = patronsController.getPatrons();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(patrons, response.getBody());
  }

  @Test
  public void testCreatePatron() {

    LibraryGuest patron = mock(LibraryGuest.class);
    doNothing().when(library).addLibraryGuest(patron);

    ResponseEntity<?> response = patronsController.createPatron(patron);

    assertEquals(HttpStatus.CREATED, response.getStatusCode());
  }

  @Test
  public void testRemovePatron() throws MediaItemCheckedOutException {

    UUID id = UUID.randomUUID();
    doNothing().when(library).removeLibraryGuest(id);

    ResponseEntity<Void> response = patronsController.removePatron(id);

    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
  }

  @Test
  public void testRemovePatronWithCheckedOutItems() throws MediaItemCheckedOutException {

    UUID id = UUID.randomUUID();
    doThrow(new MediaItemCheckedOutException("")).when(library).removeLibraryGuest(id);

    ResponseEntity<Void> response = patronsController.removePatron(id);

    assertEquals(HttpStatus.FORBIDDEN, response.getStatusCode());
  }

  @Test
  public void testGetPatron() {

    LibraryGuest mockPatron = mock(LibraryGuest.class);
    Set<LibraryGuest> patrons = Collections.singleton(mockPatron);

    when(library.getPatrons()).thenReturn(patrons);

    ResponseEntity<Collection<LibraryGuest>> response = patronsController.getPatrons();

    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(patrons, response.getBody());
  }
}
