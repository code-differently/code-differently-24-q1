package com.codedifferently.lesson16.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson16.Lesson16;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.Patron;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@ContextConfiguration(classes = Lesson16.class)
class PatronControllerTest {
  private static MockMvc mockMvc;
  @Autowired private Library library;

  private Library lib = library;

  @BeforeAll
  static void setUp(WebApplicationContext wac) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  void testController_getsAnPatron() throws Exception {
    List<LibraryGuest> pat = library.getPatrons().stream().toList();
    UUID ids = pat.get(3).getId();

    mockMvc
        .perform(get("/patrons/" + ids.toString()).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testController_getsAllPatrons() throws Exception {
    mockMvc
        .perform(get("/patrons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.patrons").isArray())
        .andExpect(jsonPath("$.patrons.length()").value(5));
  }

  @Test
  void testController_returnsNotFoundOnGetPatron() throws Exception {
    mockMvc
        .perform(
            get("/patrons/00000000-0000-0000-0000-000000000000")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testController_reportsBadRequestOnAddPatron() throws Exception {
    String json = "{}";

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.errors").isArray())
        .andExpect(jsonPath("$.errors.length()").value(1));
  }

  @Test
  void testController_addsPatron() throws Exception {
    String json =
        """
        {
          "guests":{
            {
                "id": "ca4a7abd-95fa-43db-91c7-5d80e27d821a"
                "name": "John Book",
                "email": "john.Book@reallibrary.org",
                "checkedOutPatrons": []
            }
        }
        """;

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.patron.id").value("ca4a7abd-95fa-43db-91c7-5d80e27d821a"));

    Set<LibraryGuest> patrons = new HashSet<>();
    for (LibraryGuest guest : library.getInfo().getGuests()) {
      if (guest.getId() == UUID.fromString("ca4a7abd-95fa-43db-91c7-5d80e27d821a")) {
        patrons.add(guest);
      }
    }
    assertThat(patrons).hasSize(1);
    var patron = patrons.iterator().next();
    assertThat(patron).isInstanceOf(Patron.class);
    assertThat(patron.getName()).isEqualTo("John Book");
  }

  @Test
  void testController_returnsNotFoundOnDeletePatron() throws Exception {
    mockMvc
        .perform(
            delete("/patrons/00000000-0000-0000-0000-000000000000")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testController_deletesPatron() throws Exception {
    Library lib = library;
    List<LibraryGuest> pat = library.getPatrons().stream().toList();
    UUID ids = getGuestId(pat);

    mockMvc
        .perform(delete("/patrons/" + ids.toString()).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
    int i = 0;
    pat = library.getPatrons().stream().toList();
    for (LibraryGuest guest : pat) {
      if (guest.getId() == ids) {
        i++;
      }
    }
    library = lib;
    assertThat(i).isEqualTo(0);
  }

  UUID getGuestId(List<LibraryGuest> list) {
    if (list.get(0).getCheckedOutMediaItems().size() == 0) {
      return list.get(0).getId();
    } else if (list.get(1).getCheckedOutMediaItems().size() == 0) {
      return list.get(1).getId();
    } else if (list.get(2).getCheckedOutMediaItems().size() == 0) {
      return list.get(2).getId();
    } else if (list.get(3).getCheckedOutMediaItems().size() == 0) {
      return list.get(3).getId();
    }
    return list.get(4).getId();
  }
}
