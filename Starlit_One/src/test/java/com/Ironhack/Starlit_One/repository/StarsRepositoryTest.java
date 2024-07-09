package com.Ironhack.Starlit_One.repository;

import com.Ironhack.Starlit_One.model.Stars;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StarsRepositoryTest {
    @Autowired
    StarsRepository starsRepository;

    Stars stars;

    @BeforeEach
    void setUp() {

        stars = new Stars("S17", "Vega", "blue-white", "main sequence");
        starsRepository.save(stars);
        System.out.println(stars);

    }

    @AfterEach
    void tearDown() {
        starsRepository.deleteById(stars.getId());
        //starsRepository.deleteAll();
    }

    @Test
    public void findAll_stars_starList() {
        List<Stars> starList = starsRepository.findAll();
        System.out.println(starList);
        assertEquals(1, starList.size());
    }

    @Test
    public void findById_validId_correctStars() {
        Optional<Stars> starsOptional = starsRepository.findById("S17");
        assertTrue(starsOptional.isPresent());
        System.out.println(starsOptional.get());
        assertEquals("Vega", starsOptional.get().getStars());
    }

    @Test
    public void findById_invalidId_starsNotPresent() {
        Optional<Stars> starsOptional = starsRepository.findById("S19");
        assertTrue(starsOptional.isEmpty());
    }

}