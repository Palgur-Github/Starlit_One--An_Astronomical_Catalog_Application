package com.Ironhack.Starlit_One.controller.impl;

import com.Ironhack.Starlit_One.controller.dto.StarsColorDTO;
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

    @GetMapping("/stars/starId/{starId}")
    public Stars getStarsById(@PathVariable String starId) {
        return starsService.getStarsById(starId);
    }

    // Get stars by color

    @GetMapping("/stars/color/{color}")
    public List<Stars> getStarsByColor(@PathVariable String color) {
        return starsService.getStarsByColor(color);
    }

    // Get stars by star types

    @GetMapping("/stars/starType/{starType}")
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
    @PutMapping("/stars/starId/{starId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStars(@RequestBody @Valid Stars stars, @PathVariable String starId) {
        starsService.updateStars(stars, starId);
    }

    // Update  stars' colors
    @PatchMapping("/stars/color/{starId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStarsColor(@RequestBody @Valid StarsColorDTO starsColorDTO, @PathVariable String starId) {
        starsService.updateStarsColor(starsColorDTO.getColor(), starId);
    }

    @DeleteMapping("/stars/starId/{starId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStars(@PathVariable String starId) {
        starsService.deleteStars(starId);
    }
}

