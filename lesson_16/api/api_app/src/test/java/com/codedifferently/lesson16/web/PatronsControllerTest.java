package com.codedifferently.lesson16.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.LibraryGuest;
import java.util.Collections;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

class PatronsControllerTest {

  private MockMvc mockMvc;
  private Library library;

  @BeforeEach
  public void setUp() {
    library = mock(Library.class);
    mockMvc = MockMvcBuilders.standaloneSetup(new PatronsController(library)).build();
  }

  @Test
  public void testGetPatrons() throws Exception {
    // Mocking
    Set<LibraryGuest> patrons = Collections.emptySet();
    when(library.getPatrons()).thenReturn(patrons);

    // Execution and Assertion
    mockMvc
        .perform(get("/patrons"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));
  }

  @Test
  public void testCreatePatron() throws Exception {
    // Mocking
    mockMvc
        .perform(
            post("/patrons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(
                    "{\"id\": \"123e4567-e89b-12d3-a456-426614174000\", \"name\": \"John Doe\", \"email\": \"john@example.com\"}")
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());
  }

  @Test
  public void testRemovePatron() throws Exception {
    // Execution and Assertion
    mockMvc
        .perform(delete("/patrons/{id}", "123e4567-e89b-12d3-a456-426614174000"))
        .andExpect(status().isNoContent());
  }
}
