package com.SuperheroSightings.model;

import lombok.*;

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

    // private String superType;
    private String superPower;
}
