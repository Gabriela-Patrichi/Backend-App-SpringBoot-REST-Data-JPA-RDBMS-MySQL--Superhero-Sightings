package com.SuperheroSightings.model;

import com.SuperheroSightings.dao.entity.SuperEntity;
import lombok.*;

import java.util.Date;
import java.util.List;

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

    private List<SuperDto> allSupers; //introducing a collection of Supers, corresponding to the Entity Dao mapping object
}
