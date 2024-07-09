package com.Ironhack.Starlit_One.controller.interfaces;

import com.Ironhack.Starlit_One.model.Stars;

import java.util.List;

public interface IStarsController {

    List<Stars> getAllStars();

    Stars getStarsById(String starId);

    List<Stars> getStarsByColor(String color);

    List<Stars> getStarsByStarType(String starType);

    void saveStars(Stars stars);

    void updateStars(Stars stars, String starId);

    void deleteStars(String starId);
}
