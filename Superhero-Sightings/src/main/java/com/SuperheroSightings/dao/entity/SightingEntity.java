package com.SuperheroSightings.dao.entity;

import com.SuperheroSightings.model.LocationDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity //declare the class as an entity
@Table(name = "sighting_details") //map the class to the table named sighting_details
public class SightingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sighting_id")
    private int sightingId;

    @JoinColumn(name = "location_id")
    @ManyToOne
    private LocationEntity locationEntity;

    @Column(name = "sighting_date")
    private Date locationDate;

}
