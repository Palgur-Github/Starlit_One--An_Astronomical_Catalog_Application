package com.Ironhack.Starlit_One.service.interfaces;

import com.Ironhack.Starlit_One.model.StarPattern;

import java.util.List;

public interface IStarPatternService {
    List<StarPattern> getAllStarPatterns();

    StarPattern getStarPatternsById(Integer id);

    List<StarPattern> getStarPatternsByTranslation(String translation);

    List<StarPattern> getStarPatternsByDiscoveryPeriod(String discoveryPeriod);

    void saveStarPattern(StarPattern starPattern);

    void updateStarPatternTranslation(String translation, Integer id);

    void deleteStarPattern(Integer id);

}
