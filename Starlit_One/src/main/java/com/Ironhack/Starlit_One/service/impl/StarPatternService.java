package com.Ironhack.Starlit_One.service.impl;

import com.Ironhack.Starlit_One.model.StarPattern;

import com.Ironhack.Starlit_One.repository.StarPatternRepository;
import com.Ironhack.Starlit_One.service.interfaces.IStarPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StarPatternService implements IStarPatternService {
    @Autowired
    StarPatternRepository starPatternRepository;

    @Override
    public List<StarPattern> getAllStarPatterns() {
        return starPatternRepository.findAll();
    }

    @Override
    public StarPattern getStarPatternsById(@PathVariable Integer id) {
        Optional<StarPattern> starPatternOptional = starPatternRepository.findById(id);
        if (starPatternOptional.isEmpty()) return null;
        return starPatternOptional.get();
    }

    // Get star patterns by translation

    @Override
    public List<StarPattern> getStarPatternsByTranslation(@PathVariable String translation) {
        return starPatternRepository.findAll().stream()
                .filter(starPattern -> starPattern.getTranslation().equals(translation))
                .collect(Collectors.toList());
    }

    // Get star patterns by the discovery period

    @Override
    public List<StarPattern> getStarPatternsByDiscoveryPeriod(@PathVariable String discoveryPeriod) {
        return starPatternRepository.findAll().stream()
                .filter(starPattern -> starPattern.getDiscoveryPeriod().equals(discoveryPeriod))
                .collect(Collectors.toList());
    }

    // Create a new star pattern
    @Override
    public void saveStarPattern(StarPattern starPattern) {
        starPatternRepository.save(starPattern);
    }

    // Update a star pattern's translation

    @Override
    public void updateStarPatternTranslation(String translation, Integer id) {
        Optional<StarPattern> starPatternOptional = starPatternRepository.findById(id);
        if (starPatternOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The translation " + id + " was not found");
        StarPattern starPattern = starPatternOptional.get();
        starPattern.setTranslation(translation);
        starPatternRepository.save(starPattern);
    }
}
