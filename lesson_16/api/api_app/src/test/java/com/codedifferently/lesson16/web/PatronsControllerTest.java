package com.codedifferently.lesson16.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson16.Lesson16;
import com.codedifferently.lesson16.library.Library;
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
        .andExpect(jsonPath("$.patrons").isArray())
        .andExpect(jsonPath("$.patrons.length()").value(6));
  }

  @Test
  void testController_getsPatron() throws Exception {
    mockMvc
        .perform(
            get("/patrons/31616162-3831-3832-2d34-3334352d3465")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void testController_addsPatron() throws Exception {
    String json =
        """
         {
           "patron": {
             "name": "vicente",
             "email": "vicente@example.com"
           }
         }
         """;

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.patron.name").value("vicente"));
  }
}
