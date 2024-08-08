package com.Ironhack.Starlit_One.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class StarsColorDTO {

    @NotEmpty(message = "The color cannot be empty")
    private String color;

    public String getColor() {
        return color;
    }
}

