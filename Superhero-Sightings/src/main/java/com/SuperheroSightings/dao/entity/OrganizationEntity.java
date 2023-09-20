package com.SuperheroSightings.dao.entity;

import com.SuperheroSightings.model.SuperTypeDto;
import jakarta.persistence.*;
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

@Entity //declare the class as an entity
@Table(name = "organization_details") //map the class to the table named organization_details
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto-generated Id
    @Column(name = "org_id")
    private int orgId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "org_description")
    private String orgDescription;

    @Column(name = "org_contact_info")
    private String orgContactInfo;

    @ManyToOne
    @JoinColumn(name = "org_type")
    private SuperTypeEntity orgSuperTypeEntity; //object composition

    //implement the ManyToMany relationship between the Supers and Organizations
    //joinTable name specifies the table that connects these 2 tables
    //since @JoinTable is used here, OrganizationEntity (organization_details) is the owner and super_details would be the inverse side
    //2nd attribute is joinColumns (on the FK column which connects the owner entity and the 3rd table)
    //then inverseJoinColumn (map on the FK column of the other column referencing the 3rd table)
    @ManyToMany
    @JoinTable(name = "super_organization",
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "super_id"))
    private List<SuperEntity> allSupers; //introducing a collection of Supers


}
