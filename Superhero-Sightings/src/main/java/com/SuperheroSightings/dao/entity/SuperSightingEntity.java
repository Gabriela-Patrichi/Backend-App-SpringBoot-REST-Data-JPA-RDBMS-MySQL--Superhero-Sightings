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

    @JoinColumn(name = "sighting_id")
    @ManyToOne
    private SightingEntity sightingEntity;

    @JoinColumn(name = "super_id")
    @ManyToOne
    private SuperEntity superEntity;

}
