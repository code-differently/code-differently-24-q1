package com.codedifferently.lesson16.web;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.codedifferently.lesson16.Lesson16;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;

@SpringBootTest
@ContextConfiguration(classes = Lesson16.class)
class PatronsControllerTest {
  private static MockMvc mockMvc;
  @Autowired private Library library;

  @BeforeAll
  static void setUp(WebApplicationContext wac) {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @Test
  void testController_getsAllPatrons() throws Exception {
    mockMvc
        .perform(get("/patrons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.patrons").isArray())
        .andExpect(jsonPath("$.patrons.length()").value(5));
  }

  // Got help from Mohamed on this one. Learned that .stream() is super useful.
  @Test
void testGetPatronById() throws Exception {
  
  List<LibraryGuest> patron = library.getPatrons().stream().toList();
  UUID ids = patron.get(3).getId();

  mockMvc
      .perform(get("/patrons/" + ids.toString()).contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
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
  void testPostPatron() throws Exception {
    String json =
    """
      {
        "patron": {
              "name": "Rich Hawkins",
              "email": "rich@email.com"
          }
      }
    """;

mockMvc
    .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.patron.name").value("Rich Hawkins"));

  }

  @Test
  void testController_returnsNotFoundOnDeletePatron() throws Exception {
    mockMvc
        .perform(
            delete("/patrons/00000000-0000-0000-0000-000000000000")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
// Mo' also helped on this...didn't think of making a helper function. Kudos to him!
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
      for (LibraryGuest guest : list) {
        if (guest.getCheckedOutMediaItems().isEmpty()) {
          return guest.getId();
        }
      }
      return list.get(4).getId();
    }
  }

