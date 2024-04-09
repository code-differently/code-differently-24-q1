package com.codedifferently.lesson16.web;

import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
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
import com.codedifferently.lesson16.library.Patron;

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

  
  @Test
void testGetPatronById() throws Exception {
    // Given
    UUID id = UUID.randomUUID();
    Patron patron = new Patron("John Doe", "john.doe@example.com");
    when(library.getPatrons()).thenReturn(Set.of(patron));

    // When & Then
    mockMvc.perform(get("/patrons/{id}", id))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Doe"))
            .andExpect(jsonPath("$.email").value("john.doe@example.com"));
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

  @Test
  void testController_deletesPatron() throws Exception {}
}
