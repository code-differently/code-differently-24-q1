package com.codedifferently.lesson16.web;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codedifferently.lesson16.library.Library;
import com.codedifferently.lesson16.library.Patron;
import com.codedifferently.lesson16.library.search.PatronSearchCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {Library.class, PatronsController.class})
class PatronsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Library library;

    @BeforeEach
    void setUp() {
        library.clearPatrons(); // Clear patrons before each test
    }

    @Test
    void testController_getsAllPatrons() throws Exception {
        mockMvc.perform(get("/patrons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patrons").isArray());
    }

    @Test
    void testController_getsAPatron() throws Exception {
        Patron patron = new Patron("John Doe");
        library.addLibraryGuest(patron);

        mockMvc.perform(get("/patrons/{id}", patron.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testController_returnsNotFoundOnGetPatron() throws Exception {
        mockMvc.perform(get("/patrons/{id}", "00000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testController_reportsBadRequestOnAddPatron() throws Exception {
        String json = "{}";

        mockMvc.perform(post("/patrons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errors").isArray())
                .andExpect(jsonPath("$.errors.length()").value(1));
    }

    @Test
    void testController_addsPatron() throws Exception {
        String json = "{\"name\": \"John Doe\"}";

        mockMvc.perform(post("/patrons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.patron.id").isString());

        Set<Patron> patrons = library.searchPatrons(PatronSearchCriteria.builder().name("John Doe").build());
        assertThat(patrons).hasSize(1);
    }

    @Test
    void testController_returnsNotFoundOnDeletePatron() throws Exception {
        mockMvc.perform(delete("/patrons/{id}", "00000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void testController_deletesPatron() throws Exception {
        Patron patron = new Patron("John Doe");
        library.addLibraryGuest(patron);

        mockMvc.perform(delete("/patrons/{id}", patron.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        Set<Patron> patrons = library.searchPatrons(PatronSearchCriteria.builder().id(patron.getId().toString()).build());
        assertThat(patrons).hasSize(0);
    }
}
