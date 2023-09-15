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
@Table(name = "super_sighting")
public class SuperSightingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "super_sighting_id")
    private int superSightingId;

    @ManyToOne
    @JoinColumn(name = "sighting_id")

    private SightingEntity sightingEntity;

    @ManyToOne
    @JoinColumn(name = "super_id")
    private SuperEntity superEntity;

}
