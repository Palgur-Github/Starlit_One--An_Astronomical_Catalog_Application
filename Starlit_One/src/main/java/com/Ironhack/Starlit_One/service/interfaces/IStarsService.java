package com.Ironhack.Starlit_One.service.interfaces;

import com.Ironhack.Starlit_One.model.Stars;
import java.util.List;

public interface IStarsService {
    List<Stars> getAllStars();

    Stars getStarsById(String starId);

    List<Stars> getStarsByColor(String color);

    List<Stars> getStarsByStarType(String starType);

    List<Stars> getStarsByPatternIdAndStarPatternPatternType(String patternType);

    void saveStars(Stars stars);

    void updateStars(Stars stars, String starId);
}