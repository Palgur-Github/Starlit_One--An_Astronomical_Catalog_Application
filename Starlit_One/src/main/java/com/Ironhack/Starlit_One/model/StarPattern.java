package com.Ironhack.Starlit_One.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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