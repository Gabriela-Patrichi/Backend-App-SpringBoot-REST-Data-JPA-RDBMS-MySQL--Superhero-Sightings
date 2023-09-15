package com.SuperheroSightings.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity //declare the class as an entity
@Table(name="super_type_details") //map the class to the table named super_type_details
public class SuperTypeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="type_id")
    private int superTypeId;
    @Column(name="type_name")
    private String superTypeName;
    @Column(name="type_description")
    private String superTypeDescription;

}
