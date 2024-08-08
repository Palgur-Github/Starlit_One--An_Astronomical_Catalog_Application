package com.Ironhack.Starlit_One.controller.interfaces;

import com.Ironhack.Starlit_One.model.StarPattern;

import java.util.List;

public interface IStarPatternController {

    List<StarPattern> getAllStarPatterns();

    StarPattern getStarPatternsById(Integer id);

    List<StarPattern> getStarPatternsByTranslation(String translation);

    List<StarPattern> getStarPatternsByDiscoveryPeriod(String discoveryPeriod);

    void saveStarPattern(StarPattern starPattern);

    void deleteStarPattern(Integer id);
}