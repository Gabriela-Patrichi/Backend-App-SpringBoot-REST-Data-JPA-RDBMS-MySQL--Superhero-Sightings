package com.SuperheroSightings.dao;

import com.SuperheroSightings.dao.entity.SuperEntity;
import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperDao extends JpaRepository<SuperEntity, Integer>{

//would require extra finder methods for methods aside from the 5 CRUD operations
    //te method has a particular pattern

    //for example, we want to fetch supers by their name, find by and then use the entity var name
     List<SuperEntity> findBySuperName(String superName);

     //similarly , we could use JPQL (Java Persistence Querying Language) - which works on your entities
    // can look it up
}

//JPARepository is an interface
// takes 2 generics parameters:
// entity and the data type of the PK (int becomes Integer wrapper class)

