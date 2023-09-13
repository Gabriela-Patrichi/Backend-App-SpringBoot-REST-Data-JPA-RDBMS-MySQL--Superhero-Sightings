package com.SuperheroSightings.model;

import lombok.*;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

public class SuperTypeDto {
    private int superTypeId;
    private String superTypeName;
    private String superTypeDescription;
}
