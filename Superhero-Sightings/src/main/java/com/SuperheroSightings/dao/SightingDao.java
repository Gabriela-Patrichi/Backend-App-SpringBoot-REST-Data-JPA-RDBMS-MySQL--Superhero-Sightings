package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.SightingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SightingDao extends JpaRepository<SightingEntity,Integer> {
}
