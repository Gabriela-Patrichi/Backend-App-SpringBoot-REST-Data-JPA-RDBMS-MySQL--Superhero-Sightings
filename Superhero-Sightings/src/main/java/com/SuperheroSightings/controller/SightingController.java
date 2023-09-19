package com.SuperheroSightings.controller;

import com.SuperheroSightings.model.SightingDto;
import com.SuperheroSightings.service.SightingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class SightingController {

    SightingService sightingService;
    @Autowired
    public SightingController(SightingService sightingService) {
        this.sightingService = sightingService;
    }

    // 1. fetch all sightings
    // http://localhost:7474/sightings
    @GetMapping("/sightings")
    public ResponseEntity<List<SightingDto>> fetchAllSightings(){
        // the ResponseEntity wraps up the response body(1st argument) and the status code(2nd argument)
        ResponseEntity<List<SightingDto>> responseEntity = new ResponseEntity<List<SightingDto>>(sightingService.fetchAllSightings(), HttpStatus.OK);
        return responseEntity;
    }

    // 2. fetch a sighting
    // http://localhost:7474/sightings/7
    @GetMapping("/sightings/{bid}")
    public ResponseEntity<SightingDto> fetchASighting(@PathVariable("bid") int sightingId) {
        return new ResponseEntity<SightingDto>(sightingService.fetchASighting(sightingId), HttpStatus.OK);
    }

    // 3. add a sighting
    // http://localhost:7474/sightings
    @PostMapping("/sightings")
    public ResponseEntity<SightingDto> addSighting(@RequestBody SightingDto newSighting) { //the newSighting is sent along with the request body
        return new ResponseEntity<SightingDto>(sightingService.addSighting(newSighting), HttpStatus.OK);
    }

    // 4. update a sighting
    // http://localhost:7474/sightings
    @PutMapping("/sightings")
    public ResponseEntity<SightingDto> updateSighting(@RequestBody SightingDto updateSighting) {
      return new ResponseEntity<SightingDto>(sightingService.updateSighting(updateSighting), HttpStatus.OK);
    }

    // 5. delete a sighting
    // http://localhost:7474/sightings/2
    @DeleteMapping("/sightings/{bid}")
    public ResponseEntity<Void> removeSighting(@PathVariable("bid") int sightingId) {
        sightingService.removeSighting(sightingId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    // 6. fetch sightings by a particular date
    // http://localhost:7474/sightings/date/2020-10-10
    @GetMapping("/sightings/date/{sightingDate}")
    public ResponseEntity <List<SightingDto>> fetchSightingsByDate(@PathVariable("sightingDate") LocalDate sightingDate){
        return new ResponseEntity<List<SightingDto>>(sightingService.fetchSightingsByDate(sightingDate), HttpStatus.OK);
    }

}
