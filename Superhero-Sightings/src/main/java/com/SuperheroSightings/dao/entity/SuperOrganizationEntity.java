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

    @ManyToOne
    @JoinColumn(name = "super_id")
    private SuperEntity superEntity;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationEntity organizationEntity;

}
