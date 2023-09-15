package com.SuperheroSightings.controller;

import com.SuperheroSightings.model.LocationDto;
import com.SuperheroSightings.model.OrganizationDto;
import com.SuperheroSightings.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class OrganizationController {

    OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    // 1. fetch all organizations
    // http://localhost:7474/organizations
    @GetMapping("/organizations")
    public List<OrganizationDto> fetchAllOrganizations(){
        return organizationService.fetchAllOrganizations();
    }

}
