package com.Ironhack.Starlit_One.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stars {
    @Id
    private String starId;
    private String name;
    private String color;
    @NotEmpty(message = "The color cannot be empty")
    private String starType;

    @ManyToOne
    private StarPattern starPattern;

    public String getId() {
        return starId;
    }

    public String getStars() {
        return name;
    }

}