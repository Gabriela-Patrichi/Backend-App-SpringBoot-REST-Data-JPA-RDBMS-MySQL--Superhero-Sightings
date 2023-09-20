package com.SuperheroSightings.model;

import com.SuperheroSightings.dao.entity.SightingEntity;
import com.SuperheroSightings.dao.entity.SuperEntity;
import lombok.*;

import java.util.List;

// MAKING USE OF LOMBOK , INCLUDE AN EMPTY CONSTRUCTOR, A CONSTRUCTOR WITH ALL VAR, ALL GETTERS AND SETTERS ,
// TOSTRING METHOD AND EQUALS AND HASH CODE
@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class SuperDto {

    private int superId;
    private String superName;
    private String superDescription;
    private SuperTypeDto superType;
    private String superPower;

    //to reflect the many-to-many relationship with Organizations
    private List<OrganizationDto> allOrganizations;

    //reflects the SightingEntity mapping object (many-to-many with supers)
    private List<SightingDto> allSightings;
}
