package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationDao extends JpaRepository<OrganizationEntity,Integer> {
}
