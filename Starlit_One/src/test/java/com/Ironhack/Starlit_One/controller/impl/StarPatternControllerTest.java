package com.Ironhack.Starlit_One.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.Ironhack.Starlit_One.model.StarPattern;
import com.Ironhack.Starlit_One.repository.StarPatternRepository;
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
public class StarPatternControllerTest {
    @Autowired
    StarPatternRepository starPatternRepository;


    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    StarPattern starPattern;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Optional<StarPattern> starPatternOptional = starPatternRepository.findById(3);
        assertTrue(starPatternOptional.isPresent());
        starPattern = new StarPattern(3,"Septentrio", "Seven Plough Oxen",
                "Ancient", "Asterism", 7 );
    }

    @AfterEach
    void tearDown() {
        starPatternRepository.deleteById(3);
    }

    @Test
    void getAllStarPatterns_validRequest_allStarPatterns() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/starPatterns"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Septentrio"));
    }

    @Test
    void getStarPatternsById_validId_correctStarPattern() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/starPatterns/3"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Septentrio"));
    }

    @Test
    void getStarPatternsById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/starPatterns/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    void saveStarPattern_validBody_starPatternSaved() throws Exception {
        String body = objectMapper.writeValueAsString(starPattern);

        mockMvc.perform(post("/api/starPatterns").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(starPatternRepository.findAll().toString().contains("Seven Plough Oxen"));
    }
}