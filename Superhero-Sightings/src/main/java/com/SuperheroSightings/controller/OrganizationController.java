package com.SuperheroSightings.controller;

import com.SuperheroSightings.model.LocationDto;
import com.SuperheroSightings.model.OrganizationDto;
import com.SuperheroSightings.model.SuperDto;
import com.SuperheroSightings.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public List<OrganizationDto> fetchAllOrganizations() {
        return organizationService.fetchAllOrganizations();
    }

    // 2. fetch an organization
    // http://localhost:7474/organizations/1
    @GetMapping("/organizations/{bid}")
    // PathVariable with the name bid and should be extracted and stored in orgId java var
    public ResponseEntity<OrganizationDto> fetchAnOrganization(@PathVariable("bid") int orgId) {
        return new ResponseEntity<OrganizationDto>(organizationService.fetchAnOrganization(orgId), HttpStatus.OK);
    }

    // 3. add an organization
    // http://localhost:7474/organizations
    @PostMapping("/organizations")
    public ResponseEntity<OrganizationDto> addOrganization(@RequestBody OrganizationDto newOrganization) { //the newOrganization is sent along with the request body
        return new ResponseEntity<OrganizationDto>(organizationService.addOrganization(newOrganization), HttpStatus.OK);
    }


    // 4. update an organization
    // http://localhost:7474/organizations
    @PutMapping("/organizations")
    public ResponseEntity<OrganizationDto> updateOrganization(@RequestBody OrganizationDto updateOrganization) {
        return new ResponseEntity<OrganizationDto>(organizationService.updateOrganization(updateOrganization), HttpStatus.OK);
    }

    // 5. delete a organization
    // http://localhost:7474/organizations/2
    @DeleteMapping("/organizations/{bid}")
    public ResponseEntity<Void> removeOrganization(@PathVariable("bid") int orgId) {
        organizationService.removeOrganization(orgId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
