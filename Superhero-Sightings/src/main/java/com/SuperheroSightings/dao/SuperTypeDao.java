package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperTypeDao extends JpaRepository <SuperTypeEntity,Integer>{


}

// extends JPARepository interface, which has 2 generics:
// entity and the data type of the PK (int becomes Integer wrapper class, as primitive data cannot be used as generics)