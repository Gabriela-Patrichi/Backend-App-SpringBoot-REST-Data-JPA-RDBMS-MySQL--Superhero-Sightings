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
@Table(name="organization_details") //map the class to the table named organization_details
public class OrganizationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //auto-generated Id
    @Column(name="org_id")
    private int orgId;

    @Column(name="org_name")
    private String orgName;

    @Column(name="org_description")
    private String orgDescription;

    @Column(name="org_contact_info")
    private String orgContactInfo;

    @JoinColumn(name="org_type")
    @ManyToOne
    private SuperTypeEntity orgSuperTypeEntity; //object composition

}
