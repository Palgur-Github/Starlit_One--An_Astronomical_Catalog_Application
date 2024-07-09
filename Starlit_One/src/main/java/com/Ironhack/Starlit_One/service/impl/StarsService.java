package com.Ironhack.Starlit_One.service.impl;

import com.Ironhack.Starlit_One.model.StarPattern;
import com.Ironhack.Starlit_One.model.Stars;

import com.Ironhack.Starlit_One.repository.StarsRepository;
import com.Ironhack.Starlit_One.service.interfaces.IStarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StarsService implements IStarsService {
    @Autowired
    StarsRepository starsRepository;

    Stars stars;

    @Override
    public List<Stars> getAllStars() {
        return starsRepository.findAll();
    }

    @Override
    public Stars getStarsById(@PathVariable String starId) {
        Optional<Stars> starsOptional = starsRepository.findById(starId);
        if (starsOptional.isEmpty()) return null;
        return starsOptional.get();
    }

    // Get stars by color

    @Override
    public List<Stars> getStarsByColor(@PathVariable String color) {
        return starsRepository.findAll().stream()
                .filter(stars -> stars.getColor().equals(color))
                .collect(Collectors.toList());
    }

    // Get stars by star types

    @Override
    public List<Stars> getStarsByStarType(@PathVariable String starType) {
        return starsRepository.findAll().stream()
                .filter(stars -> stars.getStarType().equals(starType))
                .collect(Collectors.toList());
    }

    // Create new stars
    @Override
    public void saveStars(Stars stars) {
        starsRepository.save(stars);
    }

    // Update stars' information
    @Override
    public void updateStars(Stars stars, String starId) {
        Optional<Stars> starsOptional = starsRepository.findById(starId);
        if (starsOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stars " + starId + " were not found");
        starsRepository.save(stars);
    }

    // Delete stars

    @Override
    public void deleteStars(String starId) {
        Optional<Stars> starsOptional = starsRepository.findById(starId);
        if (starsOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Stars " + starId + "were not found");
        starsRepository.deleteById(starId);
    }
}
