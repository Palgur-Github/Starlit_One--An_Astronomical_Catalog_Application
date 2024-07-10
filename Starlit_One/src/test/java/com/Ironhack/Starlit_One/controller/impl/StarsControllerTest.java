package com.Ironhack.Starlit_One.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.Ironhack.Starlit_One.model.Stars;
import com.Ironhack.Starlit_One.repository.StarsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class StarsControllerTest {

    @Autowired
    StarsRepository starsRepository;

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    Stars stars;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Optional<Stars> starsOptional = starsRepository.findById("S18");
        assertTrue(starsOptional.isPresent());
        stars = new Stars("S18", "Polaris", "yellow-white", "multiple star system");
    }

    @AfterEach
    void tearDown() {
        starsRepository.deleteById("S18");
    }

    @Test
    void getAllStars_validRequest_allStars() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/stars"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Polaris"));
    }

    @Test
    void getStarsById_validId_correctStars() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/stars/S18"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("S18"));
    }

    @Test
    void getStarsById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/stars/S25").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void saveStars_validBody_starsSaved() throws Exception {
        String body = objectMapper.writeValueAsString(stars);

        mockMvc.perform(post("/api/stars").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(starsRepository.findAll().toString().contains("Polaris"));
    }


    @Test
    void updateStars_validBody_starsUpdated() throws Exception {
        stars.setColor("yellow-white");

        String body = objectMapper.writeValueAsString(stars);

        mockMvc.perform(put("/api/courses/yellow-white").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(starsRepository.findAll().toString().contains("yellow-white"));
    }


    @Test
    void deleteStars_validRequest_starsDeleted() throws Exception {
        starsRepository.save(stars);

        mockMvc.perform(delete("/api/stars/polaris"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(starsRepository.findAll().toString().contains("Polaris"));
    }
}