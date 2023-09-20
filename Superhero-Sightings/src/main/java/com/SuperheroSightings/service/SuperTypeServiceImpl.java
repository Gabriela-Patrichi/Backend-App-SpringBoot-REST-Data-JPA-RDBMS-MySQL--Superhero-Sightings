package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.SuperTypeDao;
import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import com.SuperheroSightings.exception.ApplicationException;
import com.SuperheroSightings.model.SuperTypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperTypeServiceImpl implements SuperTypeService {

    private SuperTypeDao superTypeDao;

    //constructor DI
    @Autowired
    public SuperTypeServiceImpl(SuperTypeDao superTypeDao) {
        this.superTypeDao = superTypeDao;
    }

    @Override
    public List<SuperTypeDto> fetchAllSuperTypes() {

        //findAll will return a list of entities of type SuperTypeEntity
        List <SuperTypeEntity> allSuperTypesEntity = superTypeDao.findAll();

        //this entities however need to be copied into a collection of DTO, which the method returns
        List <SuperTypeDto> allSuperTypesDto= new ArrayList<SuperTypeDto>();

        //traverse the entity collection and copy each element into a DTO, which is added to the collection of SuperTypeDtos
        //using an enhanced for loop:
        for (SuperTypeEntity eachTypeEntity : allSuperTypesEntity){
            SuperTypeDto eachTypeDto = new SuperTypeDto();
            //copy each entity into a SuperTypeDto object, using BeanUtils
            BeanUtils.copyProperties(eachTypeEntity,eachTypeDto);
            //add each dto to the collection
            allSuperTypesDto.add(eachTypeDto);
        }

        //return Dto collection
        return allSuperTypesDto;
    }


    @Override
    public SuperTypeDto fetchASuperType(int superTypeId) {

        //java.util.optional was introduce in java 8 to avoid NullPointerException
        // Optional is a wrapper around the data. We have to check if the data is present and then return the value
        Optional<SuperTypeEntity> superTypeEntityOptional = superTypeDao.findById(superTypeId);
        SuperTypeDto superTypeDto = null;
        // check if superTypeEntityOptional has the data
        if(superTypeEntityOptional.isPresent()){
            //if so, copy the entity object into a dto object
            superTypeDto=new SuperTypeDto();
            BeanUtils.copyProperties(superTypeEntityOptional.get(),superTypeDto);
        }

        //if object does not exist, throw custom exception (Application Exception)
        else {
            throw new ApplicationException();
        }
        return superTypeDto;
    }

    @Override
    public SuperTypeDto addASuperType(SuperTypeDto newSuperType) {

        // the incoming newSuperType dto has to be copied into an entity object
        SuperTypeEntity newSuperTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(newSuperType, newSuperTypeEntity);

        //make use of saneAndFlush in-built method
        SuperTypeEntity savedSuperTypeEntity = superTypeDao.saveAndFlush(newSuperTypeEntity);

        // the savedSuperTypeEntity now has the auto generated type id in it
        // set the type id in the newType dto object
        newSuperType.setSuperTypeId(savedSuperTypeEntity.getSuperTypeId());

        //return the newSuperType Dto
        return newSuperType;
    }

    @Override
    public SuperTypeDto updateSuperType(SuperTypeDto updateSuperType) {

        // the incoming updateSuperType dto has to be copied into an entity object
        SuperTypeEntity updateSuperTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(updateSuperType,updateSuperTypeEntity);

        // saveAndFlush applies for both insert and update
        // if the Entity's primary key exists in the DB, ORM treats it as an update
        // if the Entity's  primary key does not exist in the DB, ORM treats it as an insert
        SuperTypeEntity savedSuperTypeEntity = superTypeDao.saveAndFlush(updateSuperTypeEntity);

        return updateSuperType;

    }

    @Override
    public void removeSuperType(int superTypeId) {
        //use the deleteById function
        superTypeDao.deleteById(superTypeId);
    }
}
