package com.SuperheroSightings.model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class SightingDto {

    private int sightingId;
    private LocationDto location;
    private Date locationDate;

}
