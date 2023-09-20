package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.SightingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SightingDao extends JpaRepository<SightingEntity,Integer> {

    //aside from the 5 CRUD operations, we need a finder method to fetch Sightings by date
    List<SightingEntity>findBySightingDate(LocalDate sightingDate);

}
