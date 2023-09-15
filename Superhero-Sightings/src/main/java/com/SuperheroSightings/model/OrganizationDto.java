package com.SuperheroSightings.model;

import lombok.*;

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

}
