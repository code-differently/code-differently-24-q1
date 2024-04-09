package com.codedifferently.lesson16.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson16.Lesson16;
import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.Patron;
import com.codedifferently.lesson16.library.search.PatronSearchCriteria;
import java.util.Set;
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
        .andExpect(jsonPath("$.patrons").isArray());
  }

  @Test
  void testController_getsAPatron() throws Exception {
    mockMvc
        .perform(get("/patrons/12345").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testController_returnsNotFoundOnGetPatron() throws Exception {
    mockMvc
        .perform(get("/patrons/00000").contentType(MediaType.APPLICATION_JSON))
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
    String json = "{\"name\": \"John Doe\"}";

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.patron.id").isString());

    Set<Patron> patrons =
        library.searchPatrons(PatronSearchCriteria.builder().name("John Doe").build());
    assertThat(patrons).hasSize(1);
  }

  @Test
  void testController_returnsNotFoundOnDeletePatron() throws Exception {
    mockMvc
        .perform(delete("/patrons/00000").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testController_deletesPatron() throws Exception {
    mockMvc
        .perform(delete("/patrons/12345").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());

    Set<Patron> patrons = library.searchPatrons(PatronSearchCriteria.builder().id("12345").build());
    assertThat(patrons).hasSize(0);
  }
}
