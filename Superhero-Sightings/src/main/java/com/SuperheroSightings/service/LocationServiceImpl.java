package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.LocationDao;
import com.SuperheroSightings.dao.entity.LocationEntity;
import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import com.SuperheroSightings.model.LocationDto;
import com.SuperheroSightings.model.SuperTypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService{

    // Dependency Injection - constructor level preferred

    private LocationDao locationDao;

    @Autowired // DI
    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public List<LocationDto> fetchAllLocations() {

        //findAll will return a list of entities of type LocationEntity
        List <LocationEntity> allLocationsEntity = locationDao.findAll();

        //these entities however need to be copied into a collection of DTO, which the method returns
        List <LocationDto> allLocationsDto= new ArrayList<LocationDto>();

        //traverse the entity collection and copy each element into a DTO, which is added to the collection of SuperTypeDtos
        //using an enhanced for loop:
        for (LocationEntity eachLocationEntity : allLocationsEntity){
            LocationDto eachLocationDto = new LocationDto();
            //copy each entity into a LocationDto object, using BeanUtils
            BeanUtils.copyProperties(eachLocationEntity,eachLocationDto);
            //add each dto to the collection
            allLocationsDto.add(eachLocationDto);
        }

        //return Dto collection
        return allLocationsDto;
    }

    @Override
    public LocationDto fetchALocation(int locationId) {
        Optional<LocationEntity> locationEntityOptional = locationDao.findById(locationId);
        LocationDto locationDto = null;
        // check if superTypeEntityOptional has the data
        if(locationEntityOptional.isPresent()){
            //if so, copy the entity object into a dto object
            locationDto =new LocationDto();
            BeanUtils.copyProperties(locationEntityOptional.get(),locationDto);
        }
        return locationDto;
    }

    @Override
    public LocationDto addLocation(LocationDto newLocation) {

        //copy the dto into an entity
        LocationEntity newLocationEntity = new LocationEntity();
        BeanUtils.copyProperties(newLocation, newLocationEntity);

        //make use of saneAndFlush in-built method
        LocationEntity savedLocationEntity = locationDao.saveAndFlush(newLocationEntity);

        // set the type id in the new dto object
       newLocation.setLocationId(savedLocationEntity.getLocationId());

        //return the  Dto
        return newLocation;
    }


    @Override
    public LocationDto updateLocation(LocationDto updateLocation) {

        // the incoming dto has to be copied into an entity object
        LocationEntity updateLocationEntity = new LocationEntity();
        BeanUtils.copyProperties(updateLocation,updateLocationEntity);

        // saveAndFlush
        LocationEntity savedLocationEntity = locationDao.saveAndFlush(updateLocationEntity);

        return updateLocation;

    }

    @Override
    public void removeLocation(int locationId) {
        //use the deleteById function
        locationDao.deleteById(locationId);

    }
}
