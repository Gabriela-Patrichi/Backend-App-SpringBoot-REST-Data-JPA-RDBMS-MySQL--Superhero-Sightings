package com.SuperheroSightings.model;

import com.SuperheroSightings.dao.entity.SuperEntity;
import lombok.*;

import java.util.List;

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

    //corresponding to the entity
    private List<SuperDto> allSupers;
}
