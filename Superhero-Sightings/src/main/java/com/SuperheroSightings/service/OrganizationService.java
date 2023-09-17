package com.SuperheroSightings.service;

import com.SuperheroSightings.model.OrganizationDto;

import java.util.List;

public interface OrganizationService {

    public List<OrganizationDto> fetchAllOrganizations();
    public OrganizationDto fetchAnOrganization (int orgId);
    public OrganizationDto addOrganization(OrganizationDto newOrganization);
    public OrganizationDto updateOrganization(OrganizationDto updateOrganization);
    public void removeOrganization(int orgId);

}
