package com.SuperheroSightings.model;

import lombok.*;

// MAKING USE OF LOMBOK , INCLUDE AN EMPTY CONSTRUCTOR, A CONSTRUCTOR WITH ALL VAR, ALL GETTERS AND SETTERS ,
// TOSTRING METHOD AND EQUALS AND HASH CODE
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
