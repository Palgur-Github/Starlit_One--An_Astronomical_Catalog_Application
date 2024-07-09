package com.Ironhack.Starlit_One.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class StarPatternTranslationDTO {
    @NotEmpty(message = "The translation cannot be empty")
    private String translation;

    public String getTranslation() {
        return translation;
    }
}
