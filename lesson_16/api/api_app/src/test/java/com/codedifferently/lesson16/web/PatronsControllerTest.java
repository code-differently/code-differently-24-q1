package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.Lesson16;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Lesson16.class)
class PatronsControllerTest {}
/*
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
  void testController_getsAnPatron() throws Exception {
    mockMvc
        .perform(
            get("/patrons/31616162-3831-3832-2d34-3334352d3465")
                .contentType(MediaType.APPLICATION_JSON))
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
  void testController_reportsBadRequestOnPatronItem() throws Exception {
    String json = "{}";

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.errors").isArray())
        .andExpect(jsonPath("$.errors.length()").value(1));
  }

  @Test
  void testController_addsItem() throws Exception {
    String json =
        """
          {
            "type": "patron",
            "name": "Jane Smith",
            "email": "jane.smith@example.com"
        }
        """;

    mockMvc
        .perform(post("/patrons").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.patrons.email").value("jane.smith@example.com"));
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
    mockMvc
        .perform(
            delete("/patron/32623932-6566-3364-2d62-3232342d3435")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNoContent());
  }
}
*/
