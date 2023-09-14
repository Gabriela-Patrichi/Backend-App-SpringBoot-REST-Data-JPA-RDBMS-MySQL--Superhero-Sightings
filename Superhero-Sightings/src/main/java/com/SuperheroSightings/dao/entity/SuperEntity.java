package com.SuperheroSightings.dao.entity;

import com.SuperheroSightings.model.SuperTypeDto;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity //declare the class as an entity
@Table(name="super_details") //map the class to the table named super_details
public class SuperEntity {

    @Id //PK
    @GeneratedValue(strategy= GenerationType.IDENTITY) //auto-generated Id
    @Column(name="super_id")
    private int superId;

    @Column(name="super_name")
    private String superName;

    @Column(name="super_description")
    private String superDescription;

    @JoinColumn(name="super_type")
    @ManyToOne // many supers can be of 1 super type
    private SuperTypeEntity superTypeEntity; //object composition

    @Column(name="super_power")
    private String superPower;
}
