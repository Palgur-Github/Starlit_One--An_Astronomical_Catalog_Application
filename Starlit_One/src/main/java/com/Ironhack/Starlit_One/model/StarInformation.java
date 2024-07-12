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
    private String starInfoId;
    private String relatedMyths;
    private String starAgeInYears;
    @ManyToOne
    private StarPattern starPattern;

}
