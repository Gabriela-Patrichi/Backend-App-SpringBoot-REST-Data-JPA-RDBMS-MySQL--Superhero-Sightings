package com.SuperheroSightings.service;

import com.SuperheroSightings.model.SuperTypeDto;

import java.util.List;

public interface SuperTypeService {

    public List<SuperTypeDto> fetchAllSuperTypes();
    public SuperTypeDto fetchASuperType (int superTypeId);
    public SuperTypeDto addASuperType(SuperTypeDto newSuperType);
    public SuperTypeDto updateSuperType(SuperTypeDto updateSuperType);
    public void removeSuperType(int superTypeId);
}
