package com.Ironhack.Starlit_One.controller.impl;

import com.Ironhack.Starlit_One.controller.interfaces.IStarsController;
import com.Ironhack.Starlit_One.model.Stars;
import com.Ironhack.Starlit_One.service.interfaces.IStarsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StarsController implements IStarsController {

    @Autowired
    IStarsService starsService;


    Stars stars;

    @GetMapping("/stars")
    public List<Stars> getAllStars() {
        return starsService.getAllStars();
    }

    @GetMapping("/patients/{patientId}")
    public Stars getStarsById(@PathVariable String starId) {
        return starsService.getStarsById(starId);
    }

    // Get stars by color

    @GetMapping("/stars/color/{color}")
    public List<Stars> getStarsByColor(@PathVariable String color) {
        return starsService.getStarsByColor(color);
    }

    // Get stars by star types

    @GetMapping("/stars/star_type/{star_type}")
    public List<Stars> getStarsByStarType(@PathVariable String starType) {
        return starsService.getStarsByStarType(starType);
    }


    // Create new stars
    @PostMapping("/stars")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStars(@RequestBody @Valid Stars stars) {
        starsService.saveStars(stars);
    }

    // Update stars' information
    @PutMapping("/stars/{starId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStars(@RequestBody @Valid Stars stars, @PathVariable String starId) {
        starsService.updateStars(stars, starId);
    }
}

