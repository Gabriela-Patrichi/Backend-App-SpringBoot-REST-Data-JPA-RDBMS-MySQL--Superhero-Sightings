package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.SuperDao;
import com.SuperheroSightings.dao.entity.*;
import com.SuperheroSightings.exception.ApplicationException;
import com.SuperheroSightings.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperServiceImpl implements SuperService {

    SuperDao superDao;

@Autowired
    public SuperServiceImpl(SuperDao superDao) {

    this.superDao = superDao;

    }

    @Override
    public List<SuperDto> fetchAllSupers() {

        List <SuperEntity> allSuperEntity = superDao.findAll();
        //this entities however need to be copied into a collection of DTO, which the method returns
        List <SuperDto> allSuperDto= new ArrayList<SuperDto>();

        //traverse through collection using the forEach method
        //consumer functional interface (consumer takes only 1 parameter; if mroe parameters are neede use ByConsumer)
        allSuperEntity.forEach((eachSuperEntity)->{
            SuperDto eachSuperDto = new SuperDto();
            BeanUtils.copyProperties(eachSuperEntity,eachSuperDto);

            //however, this will not copy the composition object which is inside each Super Entity
            //so you have to separately copy/ set it and add it
            SuperTypeDto superTypeDto= new SuperTypeDto();
            BeanUtils.copyProperties(eachSuperEntity.getSuperTypeEntity(), superTypeDto);

            //next set it in the superDto object
            eachSuperDto.setSuperType(superTypeDto);

            //REFERRING TO THE ORG MANY-TO-MANY RELATIONSHIP
            List<OrganizationDto> allOrganizationsDto = new ArrayList<OrganizationDto>();
            for(OrganizationEntity eachOrganizationEntity : eachSuperEntity.getAllOrganizations()){
                OrganizationDto eachOrganizationDto = new OrganizationDto();
                BeanUtils.copyProperties(eachOrganizationEntity,eachOrganizationDto);
                allOrganizationsDto.add(eachOrganizationDto);
            }

            //set the organization dto collection inside the super dto
            eachSuperDto.setAllOrganizations(allOrganizationsDto);

            //now the eachSuperDto contains all data and added to the collection
            allSuperDto.add(eachSuperDto);

        });
        //return the dto collection
        return allSuperDto;
    }

    @Override
    public SuperDto fetchASuper(int superId) {

        Optional<SuperEntity> superEntityOptional = superDao.findById(superId);
        SuperDto superDto = null;
        // check if superTypeEntityOptional has the data
        if(superEntityOptional.isPresent()){
            //if so, copy the entity object into a dto object
            superDto =new SuperDto();
            BeanUtils.copyProperties(superEntityOptional.get(),superDto);

            //copy the composition entity object (which is inside the superEntityOptional) into a dto type of object
            SuperTypeDto superTypeDto= new SuperTypeDto();
            BeanUtils.copyProperties(superEntityOptional.get().getSuperTypeEntity(), superTypeDto);

            //next, set it in the superDto object
            superDto.setSuperType(superTypeDto);

            //Similarly , deal with the collection of Organizations object composition
            List<OrganizationDto> allOrganizationsDto = new ArrayList<OrganizationDto>();
           // BeanUtils.copyProperties(superEntityOptional.get().getAllOrganizations(), organizationsDtoOfSuper);

            for(OrganizationEntity eachOrganizationEntity: superEntityOptional.get().getAllOrganizations()){
                OrganizationDto eachOrganizationDto = new OrganizationDto();
                BeanUtils.copyProperties(eachOrganizationEntity, eachOrganizationDto);
                allOrganizationsDto.add(eachOrganizationDto);
            }
            //set it in each SuperDto obj
            superDto.setAllOrganizations(allOrganizationsDto);


            //Similarly , deal with the collection of Sighting object composition
            List<SightingDto> allSightingsDto = new ArrayList<SightingDto>();
            for(SightingEntity eachSightingEntity: superEntityOptional.get().getAllSightings()){
                SightingDto eachSightingDto = new SightingDto();
                BeanUtils.copyProperties(eachSightingEntity, eachSightingDto);

            //now, also include the Location object which a Sighting object contains
                LocationDto locationDto = new LocationDto();
               LocationEntity locationEntity = eachSightingEntity.getLocationEntity();
               BeanUtils.copyProperties(locationEntity, locationDto);

                //set it in each SightingDto obj
                eachSightingDto.setLocation(locationDto);

                //now add each sighting(containing also location object) to the collection of SightingDto
                allSightingsDto.add(eachSightingDto);
            }

        //set it in each SuperDto obj
            superDto.setAllSightings(allSightingsDto);

        }
        //if object does not exist, throw custom exception (Application Exception)
        else {
            throw new ApplicationException();
        }
        return superDto;
    }



    @Override
    public SuperDto addSuper(SuperDto newSuper) {

        SuperEntity newSuperEntity = new SuperEntity();
        BeanUtils.copyProperties(newSuper, newSuperEntity);

        //will need to copy the supertype object in the super object
        //first copy the entity
        SuperTypeEntity superTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(newSuper.getSuperType(), superTypeEntity);

        //set the superType entity within the superEntity
        newSuperEntity.setSuperTypeEntity(superTypeEntity);

        //make use of saneAndFlush in-built method for the newSuperEntity (containing also the supertype entity)
        superDao.saveAndFlush(newSuperEntity);

        newSuper.setSuperId(newSuperEntity.getSuperId());

        //return the SuperDto
        return newSuper;

    }

    @Override
    public SuperDto updateSuper(SuperDto updateSuper) {

        // the incoming dto has to be copied into an entity object
        SuperEntity updateSuperEntity = new SuperEntity();
        BeanUtils.copyProperties(updateSuper,updateSuperEntity);

        //will need to copy the SuperType object in the Super object
        //first copy the entity
        SuperTypeEntity superTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(updateSuper.getSuperType(), superTypeEntity);

        //set the superType entity within the superEntity
        updateSuperEntity.setSuperTypeEntity(superTypeEntity);

        //saveAndFlush in-built method for the updateSuperEntity (containing also the SuperTypeEntity)
        superDao.saveAndFlush(updateSuperEntity);

        return updateSuper;

    }

    @Override
    public void removeSuper(int superId) {

    superDao.deleteById(superId);
    // this will not remove the supertype too, if we want so we nee dto specify the cascade
        // either at SQL table or SuperEntity @Many to One here add cascade too

    }

    @Override
    public List<SuperDto> fetchSuperByName(String superName) {
        return null;
    }
}
