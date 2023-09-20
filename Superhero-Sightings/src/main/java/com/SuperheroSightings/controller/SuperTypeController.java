package com.SuperheroSightings.controller;

import com.SuperheroSightings.model.SuperTypeDto;
import com.SuperheroSightings.service.SuperTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SuperTypeController {

    SuperTypeService superTypeService;

    @Autowired
    public SuperTypeController(SuperTypeService superTypeService) {
        this.superTypeService = superTypeService;
    }


    // 1. fetch all super types
    // http://localhost:7474/supertypes
    @GetMapping("/supertypes")
    public List<SuperTypeDto> fetchAllSuperTypes() {
        return superTypeService.fetchAllSuperTypes();
    }

    // 2. fetch a supertype
    // http://localhost:7474/supertypes/1
    @GetMapping("/supertypes/{aid}")
    public SuperTypeDto fetchASuperType(@PathVariable("aid") int superTypeId) {
        return superTypeService.fetchASuperType(superTypeId);
    }

    // 3. add a supertype
    // http://localhost:7474/supertypes
    @PostMapping("/supertypes")
    public SuperTypeDto addSuperType(@RequestBody SuperTypeDto newSuperType) {
        return superTypeService.addASuperType(newSuperType);
    }

    // 4. update a supertype
    // http://localhost:7474/supertypes
    @PutMapping("/supertypes")
    public SuperTypeDto updateSuperType(@RequestBody SuperTypeDto updateSuperType) {
        return superTypeService.updateSuperType(updateSuperType);
    }

    // 5. delete a supertype
    // http://localhost:7474/supertypes/3
    @DeleteMapping("/supertypes/{aid}")
    public void removeSuperType(@PathVariable("aid") int superTypeId) {
        superTypeService.removeSuperType(superTypeId);
    }


}


