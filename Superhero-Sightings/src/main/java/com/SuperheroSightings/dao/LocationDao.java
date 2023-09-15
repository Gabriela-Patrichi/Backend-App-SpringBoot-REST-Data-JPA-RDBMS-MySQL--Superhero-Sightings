package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<LocationEntity, Integer> {

}
