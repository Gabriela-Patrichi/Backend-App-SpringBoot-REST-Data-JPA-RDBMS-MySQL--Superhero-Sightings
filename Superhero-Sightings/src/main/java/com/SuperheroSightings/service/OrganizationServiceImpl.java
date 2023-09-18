package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.OrganizationDao;
import com.SuperheroSightings.dao.entity.OrganizationEntity;
import com.SuperheroSightings.dao.entity.SuperEntity;
import com.SuperheroSightings.dao.entity.SuperTypeEntity;
import com.SuperheroSightings.model.OrganizationDto;
import com.SuperheroSightings.model.SuperDto;
import com.SuperheroSightings.model.SuperTypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationDto> fetchAllOrganizations() {

        //findAll will return a collection of OrganizationEntity objects
        List <OrganizationEntity> allOrganizationsEntity = organizationDao.findAll();

        //copy the entities into a collection of DTO
        List <OrganizationDto> allOrganizationsDto= new ArrayList<OrganizationDto>();

        //traverse through collection using the forEach method
        allOrganizationsEntity.forEach((eachOrganizationEntity)->{
            OrganizationDto eachOrganizationDto = new OrganizationDto();
            BeanUtils.copyProperties(eachOrganizationEntity,eachOrganizationDto);
            //however, this will not copy the composition object (SuperType) which is inside each Organization
            //so, will have to separately copy/ set and add it separately
            SuperTypeDto superTypeDto= new SuperTypeDto();
            BeanUtils.copyProperties(eachOrganizationEntity.getOrgSuperTypeEntity(), superTypeDto);

            //next set it in the OrganizationDto object
            eachOrganizationDto.setOrgType(superTypeDto);

            //SIMILARLY, traverse through the collection of Super Entity and add theentty into a DTO object
            List<SuperDto> allSupersDto = new ArrayList<SuperDto>();
            for(SuperEntity eachSuperEntity: eachOrganizationEntity.getAllSupers()){
                SuperDto eachSuperDto = new SuperDto();
                BeanUtils.copyProperties(eachSuperEntity, eachSuperDto);

                // however, now I need to also copy the supertype object inside the super type
                allSupersDto.add(eachSuperDto);
            }

            //set it in each OrgDTO obj
            eachOrganizationDto.setAllSupers(allSupersDto);

            //add the Dto to the collection (containing now the object superTypeDto too)
            allOrganizationsDto.add(eachOrganizationDto);

        });
        //return the dto collection
        return allOrganizationsDto;

    }

    @Override
    public OrganizationDto fetchAnOrganization(int orgId) {

        Optional<OrganizationEntity> optionalOrganizationEntity = organizationDao.findById(orgId);
        OrganizationDto organizationDto = null;
        // check if superTypeEntityOptional has the data
        if(optionalOrganizationEntity.isPresent()){
            //if so, copy the entity object into a dto object
            organizationDto =new OrganizationDto();
            BeanUtils.copyProperties(optionalOrganizationEntity.get(),organizationDto);

            //copy the composition entity object (which is inside the superEntityOptional) into a dto type of object
            SuperTypeDto superTypeDto= new SuperTypeDto();
            BeanUtils.copyProperties(optionalOrganizationEntity.get().getOrgSuperTypeEntity(), superTypeDto);

            //next set it in the superDto object
            organizationDto.setOrgType(superTypeDto);

            //similarly, introduce the collection of Supers which an organization contains
            List<SuperEntity> allSuperEntity= optionalOrganizationEntity.get().getAllSupers();
            List<SuperDto> allSupersDto = new ArrayList<SuperDto>();
            //this will have an empty collection only
            //   BeanUtils.copyProperties(allSuperEntity,allSupersDto);
            //put together the collection 1 by 1

            for(SuperEntity eachSuperEntity: optionalOrganizationEntity.get().getAllSupers()){
                SuperDto eachSuperDto = new SuperDto();
                BeanUtils.copyProperties(eachSuperEntity, eachSuperDto);
                allSupersDto.add(eachSuperDto);
            }

            //set it in each OrgDTO obj
            organizationDto.setAllSupers(allSupersDto);

        }
        return organizationDto;
    }

    @Override
    public OrganizationDto addOrganization(OrganizationDto newOrganization) {

        //copy the incoming dto into a organization entity
        OrganizationEntity newOrganizationEntity = new OrganizationEntity();
        BeanUtils.copyProperties(newOrganization, newOrganizationEntity);

        //will also need to copy the supertype object in the organization object
        //1. copy the entity
        SuperTypeEntity superTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(newOrganization.getOrgType(), superTypeEntity);

        //2. set the superType entity within the OrganizationEntity we are dealing
        newOrganizationEntity.setOrgSuperTypeEntity(superTypeEntity);

        //use saveAndFlush method for the newOrganizationEntity (containing also the supertype entity)
        organizationDao.saveAndFlush(newOrganizationEntity);

        newOrganization.setOrgId(newOrganizationEntity.getOrgId());

        //return the OrganizationDto object
        return newOrganization;
    }

    @Override
    public OrganizationDto updateOrganization(OrganizationDto updateOrganization) {

        // the incoming dto has to be copied into an entity object
        OrganizationEntity updateOrganizationEntity = new OrganizationEntity();
        BeanUtils.copyProperties(updateOrganization,updateOrganizationEntity);

        //will need to copy the SuperType object in the Super object
        SuperTypeEntity superTypeEntity = new SuperTypeEntity();
        BeanUtils.copyProperties(updateOrganization.getOrgType(), superTypeEntity); //copy the entity

        //set the superOrgType entity within the updateOrganizationEntity
        updateOrganizationEntity.setOrgSuperTypeEntity(superTypeEntity);

        //saveAndFlush (containing also the SuperTypeEntity)
        organizationDao.saveAndFlush(updateOrganizationEntity);

        return updateOrganization;
    }

    @Override
    public void removeOrganization(int orgId) {

        organizationDao.deleteById(orgId);

    }
}
