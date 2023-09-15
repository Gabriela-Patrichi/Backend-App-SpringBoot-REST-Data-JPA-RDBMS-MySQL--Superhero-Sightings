package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.SuperEntity;
import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperDao extends JpaRepository<SuperEntity, Integer>{


}

//JPARepository is an interface
// takes 2 generics parameters:
// entity and the data type of the PK (int becomes Integer wrapper class)

