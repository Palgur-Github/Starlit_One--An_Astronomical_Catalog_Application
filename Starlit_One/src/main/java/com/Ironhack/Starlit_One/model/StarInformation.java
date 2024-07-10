package com.Ironhack.Starlit_One.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@DiscriminatorValue("info")  // to distinguish between Stars and StarInfo
@Inheritance
public class StarInformation extends Stars {
    private String relatedMyths;
    private Double starAgeInYears;
    @OneToOne
    private StarPattern starPattern;
}
