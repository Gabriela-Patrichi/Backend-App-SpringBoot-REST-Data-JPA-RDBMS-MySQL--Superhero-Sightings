package com.SuperheroSightings.controller;


import com.SuperheroSightings.model.SuperDto;
import com.SuperheroSightings.service.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SuperController {

    SuperService superService;

    @Autowired
    public SuperController(SuperService superService) {
        this.superService = superService;
    }


    // 1. fetch all supers
    // http://localhost:7474/supers
    @GetMapping("/supers")
    public ResponseEntity<List<SuperDto>> fetchAllSupers(){
        // the ResponseEntity wraps up the response body(1st argument) and the status code(2nd argument)
        ResponseEntity<List<SuperDto>> responseEntity = new ResponseEntity<List<SuperDto>>(superService.fetchAllSupers(), HttpStatus.OK);
        return responseEntity;
    }


    // 2. fetch a super
    // http://localhost:7474/supers/2
    @GetMapping("/supers/{bid}")  // PathVariable with the name bid and should be extracted and store in a java variable/parameter(superId)
    public ResponseEntity<SuperDto> fetchSuper(@PathVariable("bid") int superId) {
        return new ResponseEntity<SuperDto>(superService.fetchASuper(superId), HttpStatus.OK);
    }

    // 3. add a super
    // http://localhost:7474/supers
    @PostMapping("/supers")
    public ResponseEntity<SuperDto> addSuper(@RequestBody SuperDto newSuper) { //the newSuper is sent along with the request body
        return new ResponseEntity<SuperDto>(superService.addSuper(newSuper), HttpStatus.OK);
    }

    // 4. update a super
    // http://localhost:7474/supers
    @PutMapping("/supers")
    public ResponseEntity<SuperDto> updateSuper(@RequestBody SuperDto updateSuper) {
        return new ResponseEntity<SuperDto>(superService.updateSuper(updateSuper), HttpStatus.OK);
    }

    // 5. delete a super
    // http://localhost:7474/supers/2
    @DeleteMapping("/supers/{bid}")
    public ResponseEntity<Void> removeSuper(@PathVariable("bid") int superId) {
        superService.removeSuper(superId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}






