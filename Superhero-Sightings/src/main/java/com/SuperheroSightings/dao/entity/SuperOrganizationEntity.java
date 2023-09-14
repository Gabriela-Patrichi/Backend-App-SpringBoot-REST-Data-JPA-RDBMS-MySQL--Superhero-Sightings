package com.SuperheroSightings.dao.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity
@Table(name = "super_organization")
public class SuperOrganizationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_org_id")
    private int superOrg;

    @JoinColumn(name = "super_id")
    @ManyToOne
    private SuperEntity superEntity;

    @JoinColumn(name = "org_id")
    @ManyToOne
    private OrganizationEntity organizationEntity;

}
