package com.SuperheroSightings.service;


import com.SuperheroSightings.model.SuperDto;

import java.util.List;

public interface SuperService {

    public List<SuperDto> fetchAllSupers();
    public SuperDto fetchASuper (int superId);
    public SuperDto addSuper(SuperDto newSuper);
    public SuperDto updateSuper(SuperDto updateSuper);
    public void removeSuper(int superId);

    public List<SuperDto> fetchSuperByName(String superName);
}
