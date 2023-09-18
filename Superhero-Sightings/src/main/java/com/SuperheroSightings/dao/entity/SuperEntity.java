package com.SuperheroSightings.dao.entity;

import com.SuperheroSightings.model.SuperTypeDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    @Column(name="super_id") //mapped to the super_id column
    private int superId;

    @Column(name="super_name") //mapped to the super_name column
    private String superName;

    @Column(name="super_description") //mapped to the super_description column
    private String superDescription;

    @ManyToOne // many supers can be of 1 super type
    @JoinColumn(name="super_type") //mapped to the super_type column
    private SuperTypeEntity superTypeEntity; //object composition

    @Column(name="super_power") //mapped to the super_power column
    private String superPower;

    //implement the ManyToMany relationship between the Supers and Organizations
    //mappedBy because this is now the inverse side (the owner was the Org)
    //mapped by the name of the private collection on the org side
    //mappedBy property
    @ManyToMany(mappedBy = "allSupers")
    private List<OrganizationEntity> allOrganizations;


}

//AUTO vs Identity, not the Same. Auto does not mean here auto increment value

