package com.SuperheroSightings.dao.entity;

import com.SuperheroSightings.model.LocationDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity locationEntity;

    @Column(name = "sighting_date")
    private LocalDate sightingDate;

    //implement the ManyToMany relationship between the Sightings and Supers
    //joinTable name specifies the table that connects these 2 tables
    //since @JoinTable is used here, sighting_details is the owner and super_details would be the inverse side
    //2nd attribute is joinColumns (on the FK column which connects the owner entity and the 3rd table)
    //and 3rd attribute inverseJoinColumn (map on the FK column of the other column referencing the 3rd table)
    @ManyToMany
    @JoinTable (name = "super_sighting",
            joinColumns = @JoinColumn(name="sighting_id"),
            inverseJoinColumns = @JoinColumn(name = "super_id"))
    private List<SuperEntity> allSupers; //introducing a collection of Supers



}
