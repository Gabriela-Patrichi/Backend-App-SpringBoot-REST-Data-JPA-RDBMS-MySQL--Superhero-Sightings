package com.SuperheroSightings.model;

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

public class OrganizationDto {

    private int orgId;
    private String orgName;
    private String orgDescription;
    private String orgContactInfo;
    private SuperTypeDto orgType;

    //corresponding to the entity (ManytoMany mapping)
    private List<SuperDto> allSupers;
}
