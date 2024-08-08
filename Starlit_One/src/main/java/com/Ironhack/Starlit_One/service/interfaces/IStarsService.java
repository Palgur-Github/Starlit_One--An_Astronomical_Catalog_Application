package com.Ironhack.Starlit_One.service.interfaces;

import com.Ironhack.Starlit_One.model.Stars;

import java.util.List;

public interface IStarsService {
    List<Stars> getAllStars();

    Stars getStarsById(String starId);

    List<Stars> getStarsByColor(String color);

    List<Stars> getStarsByStarType(String starType);

    void saveStars(Stars stars);

    void updateStars(Stars stars, String starId);

    void updateStarsColor(String color, String starId);

    void deleteStars(String starId);
}