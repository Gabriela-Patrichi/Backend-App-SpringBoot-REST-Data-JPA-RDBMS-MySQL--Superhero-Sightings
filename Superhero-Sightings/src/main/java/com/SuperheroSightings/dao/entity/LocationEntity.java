package com.SuperheroSightings.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor //empty constructor
@AllArgsConstructor //a constructor using all attributes
@Getter //for getters
@Setter //for setters
@ToString //to use ToString method
@EqualsAndHashCode // equals and hash code

@Entity //declare the class as an entity
@Table(name="location_details") //map the class to the table named location_details

public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="location_id")
    private int locationId;

    @Column(name="location_name")
    private String locationName;

    @Column(name="location_desc")
    private String locationDescription;

    @Column(name="location_address")
    private String locationAddress;

    @Column(name="location_latitude")
    private BigDecimal latitude;

    @Column(name="location_longitude")
    private BigDecimal longitude;

    //one to many relationship with Sighting, achieving therefore bidirectional mapping
    @OneToMany(mappedBy = "locationEntity")
    private List<SightingEntity> allsightings;

}
