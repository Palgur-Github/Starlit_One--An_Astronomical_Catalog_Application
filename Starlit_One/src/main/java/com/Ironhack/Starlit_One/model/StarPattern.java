package com.Ironhack.Starlit_One.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarPattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String translation;
    @NotEmpty(message = "The translation cannot be empty")
    private String discoveryPeriod;
    private String patternType;
    private Integer mainStarCount;

    public Integer getId() {
        return id;
    }

    public String getStarPattern() {
        return name;
    }
}