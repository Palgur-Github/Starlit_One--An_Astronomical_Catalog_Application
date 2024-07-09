package com.Ironhack.Starlit_One.repository;

import com.Ironhack.Starlit_One.model.StarPattern;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StarPatternRepositoryTest {
    @Autowired
    StarPatternRepository starPatternRepository;

    StarPattern starPattern;

    @BeforeEach
    void setUp() {

        starPattern = new StarPattern(2, "Sagitta", "The Arrow", "Ancient", "Constellation", 4);
        starPatternRepository.save(starPattern);
        System.out.println(starPattern);
    }

    @AfterEach
    void tearDown() {
        starPatternRepository.deleteById(starPattern.getId());
    }

    @Test
    public void findAll_StarPatterns_StarPatternList() {
        List<StarPattern> starPatterns = starPatternRepository.findAll();
        System.out.println(starPatterns);
        assertEquals(4, starPatterns.size());
    }

    @Test
    public void findById_validId_correctStarPattern() {
        Optional<StarPattern> starPatternOptional = starPatternRepository.findById(1);
        assertTrue(starPatternOptional.isPresent());
        System.out.println(starPatternOptional.get());
        assertEquals("Sagitta", starPatternOptional.get().getStarPattern());
    }

    @Test
    public void findById_invalidId_starPatternNotPresent() {
        Optional<StarPattern> starPatternOptional = starPatternRepository.findById(2);
        assertTrue(starPatternOptional.isEmpty());
    }

}