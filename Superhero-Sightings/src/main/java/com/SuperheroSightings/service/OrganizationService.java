package com.SuperheroSightings.service;

import com.SuperheroSightings.model.OrganizationDto;

import java.util.List;

public interface OrganizationService {

    public List<OrganizationDto> fetchAllOrganizations();
    public OrganizationDto fetchAnOrganization (int orgId);
    public OrganizationDto addOrganization(OrganizationDto newSuper);
    public OrganizationDto updateOrganization(OrganizationDto updateSuper);
    public void removeOrganization(int superId);

}
