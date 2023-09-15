package com.SuperheroSightings.service;

import com.SuperheroSightings.dao.OrganizationDao;
import com.SuperheroSightings.dao.entity.OrganizationEntity;
import com.SuperheroSightings.model.OrganizationDto;
import com.SuperheroSightings.model.SuperTypeDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

            //add the Dto to the collection (containing now the object superTypeDto too)
            allOrganizationsDto.add(eachOrganizationDto);

        });
        //return the dto collection
        return allOrganizationsDto;

    }

    @Override
    public OrganizationDto fetchAnOrganization(int orgId) {
        return null;
    }

    @Override
    public OrganizationDto addOrganization(OrganizationDto newSuper) {
        return null;
    }

    @Override
    public OrganizationDto updateOrganization(OrganizationDto updateSuper) {
        return null;
    }

    @Override
    public void removeOrganization(int superId) {

    }
}
