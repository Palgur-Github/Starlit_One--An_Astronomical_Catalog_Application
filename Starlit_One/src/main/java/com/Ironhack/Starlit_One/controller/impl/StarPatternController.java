package com.Ironhack.Starlit_One.controller.impl;

import com.Ironhack.Starlit_One.controller.dto.StarPatternTranslationDTO;
import com.Ironhack.Starlit_One.controller.interfaces.IStarPatternController;
import com.Ironhack.Starlit_One.model.StarPattern;
import com.Ironhack.Starlit_One.service.interfaces.IStarPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarPatternController implements IStarPatternController {

    @Autowired
    IStarPatternService starPatternService;

    @GetMapping("/starPatterns")
    public List<StarPattern> getAllStarPatterns() {
        return starPatternService.getAllStarPatterns();
    }

    @GetMapping("/starPatterns/id/{id}")
    public StarPattern getStarPatternsById(@PathVariable Integer id) {
        return starPatternService.getStarPatternsById(id);
    }
    // Get star patterns by translation

    @GetMapping("/starPatterns/translation/{translation}")
    public List<StarPattern> getStarPatternsByTranslation(@PathVariable String translation) {
        return starPatternService.getStarPatternsByTranslation(translation);
    }

    // Get star patterns by the discovery period

    @GetMapping("/starPatterns/discoveryPeriod/{discoveryPeriod}")
    public List<StarPattern> getStarPatternsByDiscoveryPeriod(@PathVariable String discoveryPeriod) {
        return starPatternService.getStarPatternsByDiscoveryPeriod(discoveryPeriod);
    }

    // Create a new star pattern
    @PostMapping("/starPatterns")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStarPattern(@RequestBody @Valid StarPattern starPattern) {
        starPatternService.saveStarPattern(starPattern);
    }

    // Update  a star pattern's translation
    @PatchMapping("/starPatterns/translation/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStarPatternTranslation(@RequestBody @Valid StarPatternTranslationDTO starPatternTranslationDTO, @PathVariable Integer id) {
        starPatternService.updateStarPatternTranslation(starPatternTranslationDTO.getTranslation(), id);
    }

    // Delete a star pattern

    @DeleteMapping("/starPatterns/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStarPattern(@PathVariable Integer id) {
        starPatternService.deleteStarPattern(id);
    }
}