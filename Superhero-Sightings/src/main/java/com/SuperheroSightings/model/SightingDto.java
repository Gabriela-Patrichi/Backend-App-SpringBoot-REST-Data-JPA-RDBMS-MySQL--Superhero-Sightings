package com.SuperheroSightings.model;

import com.SuperheroSightings.dao.entity.SuperEntity;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

// MAKING USE OF LOMBOK , INCLUDE AN EMPTY CONSTRUCTOR, A CONSTRUCTOR WITH ALL VAR, ALL GETTERS AND SETTERS ,
// TOSTRING METHOD AND EQUALS AND HASH CODE
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class SightingDto {

    private int sightingId;
    private LocationDto location;
    private LocalDate sightingDate;

    private List<SuperDto> allSupers; //introducing a collection of Supers, corresponding to the Entity Dao mapping object
}
