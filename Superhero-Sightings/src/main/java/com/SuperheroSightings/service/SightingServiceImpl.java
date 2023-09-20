package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.SightingDao;
import com.SuperheroSightings.dao.entity.*;
import com.SuperheroSightings.exception.ApplicationException;
import com.SuperheroSightings.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class SightingServiceImpl implements SightingService {

    SightingDao sightingDao;

    //constructor Dependency Injection
    @Autowired
    public SightingServiceImpl(SightingDao sightingDao) {
        this.sightingDao = sightingDao;
    }

    @Override
    public List<SightingDto> fetchAllSightings() {

        //use findAll method, which returns a collection of Sighting entities
        List<SightingEntity> allSightingsEntities = sightingDao.findAll();

        //these entities need then to be copied in a DTO type of collection
        List<SightingDto> allSightingsDto = new ArrayList<SightingDto>();

        //traverse through collection using the forEach method
        allSightingsEntities.forEach((eachSightingEntity)->{
            SightingDto eachSightingDto = new SightingDto();
            BeanUtils.copyProperties(eachSightingEntity,eachSightingDto);

            //now copy the location object inside each sighting
            LocationDto locationDto = new LocationDto();
            BeanUtils.copyProperties(eachSightingEntity.getLocationEntity(), locationDto);

            //also set it in the SightingDto object
            eachSightingDto.setLocation(locationDto);

            //add the Dto to the collection (now including the object composition too)
            allSightingsDto.add(eachSightingDto);

        });
        //return the dto collection
        return allSightingsDto;
    }



    @Override
    public SightingDto fetchASighting(int sightingId) {
        //findById return an Optional<Entity> type
        Optional<SightingEntity> optionalSightingEntity = sightingDao.findById(sightingId);
        SightingDto sightingDto = null;
        // if optionalSightingEntity has data, copy the entity to a corresponding SightingDTO object
        if (optionalSightingEntity.isPresent()){
            sightingDto = new SightingDto();
            BeanUtils.copyProperties(optionalSightingEntity.get(), sightingDto);

            //also copy the Location object entity inside the Sighting Entity
            LocationDto locationDto = new LocationDto();
            BeanUtils.copyProperties(optionalSightingEntity.get().getLocationEntity(), locationDto);

            //now set the location dto into the sighting dto
            sightingDto.setLocation(locationDto);


            //now, also include the Supers collection which Sighting object contains
            List<SuperDto> allSupersDto = new ArrayList<SuperDto>();
            for(SuperEntity eachSuperEntity: optionalSightingEntity.get().getAllSupers()){
                SuperDto eachSuperDto = new SuperDto();
                BeanUtils.copyProperties(eachSuperEntity, eachSuperDto);
                allSupersDto.add(eachSuperDto);
            }

            //set it in each SightingDto obj
            sightingDto.setAllSupers(allSupersDto);
        }

        //if object does not exist, throw custom exception (Application Exception)
        else {
            throw new ApplicationException();
        }

        //return the sightingDto object
        return sightingDto;
    }


    @Override
    public SightingDto addSighting(SightingDto newSighting) {

        //copy the incoming DTO in an entity object
        SightingEntity newSightingEntity = new SightingEntity();
        BeanUtils.copyProperties(newSighting,newSightingEntity);

        //copy also the inner location object
        LocationEntity locationEntity = new LocationEntity();
        BeanUtils.copyProperties(newSighting.getLocation(), locationEntity);

        //set the location entity as an object of the newSightingEntity
        newSightingEntity.setLocationEntity(locationEntity);

        //saveAndFlush
        sightingDao.saveAndFlush(newSightingEntity);

        //set the Id of the sightingDto
        newSighting.setSightingId(newSightingEntity.getSightingId());

        //return the newSightingDto, containing now the Id too
        return newSighting;
    }

    @Override
    public SightingDto updateSighting(SightingDto updateSighting) {

        //copy the incoming DTO in an entity object
        SightingEntity updateSightingEntity = new SightingEntity();
        BeanUtils.copyProperties(updateSighting,updateSightingEntity);

        //copy also the inner location object
        LocationEntity locationEntity = new LocationEntity();
        BeanUtils.copyProperties(updateSighting.getLocation(),locationEntity);

        //set the location entity as an object of the newSightingEntity
        updateSightingEntity.setLocationEntity(locationEntity);

        //saveAndFlush
        sightingDao.saveAndFlush(updateSightingEntity);

        return updateSighting;

    }

    @Override
    public void removeSighting(int sightingId) {
        //deleteById method
        sightingDao.deleteById(sightingId);
    }

    @Override
    public List<SightingDto> fetchSightingsByDate(LocalDate sightingDate) {

        //call the findByDate method from the Dao layer
        List<SightingEntity> allSightingEntity = sightingDao.findBySightingDate(sightingDate);
        List<SightingDto> allSightingDto = new ArrayList<SightingDto>();

        //traverse the collection to get each entity, copy it in a dto and add it to the SightingDto collection of
        for (SightingEntity eachSightingEntity: allSightingEntity){
            SightingDto eachSightingDto = new SightingDto();
            BeanUtils.copyProperties(eachSightingEntity,eachSightingDto);

            //now also include the location object and the collections of supers

            //copy the location object inside each sighting
            LocationDto locationDto = new LocationDto();
            BeanUtils.copyProperties(eachSightingEntity.getLocationEntity(), locationDto);
            //set locationDto object in the SightingDto object
            eachSightingDto.setLocation(locationDto);

            //include the Supers collection which each Sighting object contains
            List<SuperDto> allSupersDto = new ArrayList<SuperDto>();
            for(SuperEntity eachSuperEntity: eachSightingEntity.getAllSupers()){
                SuperDto eachSuperDto = new SuperDto();
                BeanUtils.copyProperties(eachSuperEntity, eachSuperDto);
                allSupersDto.add(eachSuperDto);

                //set the collection inside each sightingDto
                eachSightingDto.setAllSupers(allSupersDto);
            }

            //add the eachSightingDto (containg the SuperSto collection and the ObjectDto) to the collection
            allSightingDto.add(eachSightingDto);
        }

        //return collection of Sightings
        return allSightingDto;
    }
}

