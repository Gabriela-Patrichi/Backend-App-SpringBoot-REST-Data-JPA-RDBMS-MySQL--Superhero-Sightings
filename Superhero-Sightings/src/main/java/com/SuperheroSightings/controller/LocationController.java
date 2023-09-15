package com.SuperheroSightings.controller;

import com.SuperheroSightings.model.LocationDto;
import com.SuperheroSightings.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class LocationController {

    LocationService locationService;
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    // 1. fetch all locations
    // http://localhost:7474/locations
    @GetMapping("/locations")
    public List<LocationDto> fetchAllLocations(){
        return locationService.fetchAllLocations();
    }

    // 2. fetch a location
    // http://localhost:7474/locations/1
    @GetMapping("/locations/{aid}")
    public LocationDto fetchALocation(@PathVariable("aid") int locationId) {
        return locationService.fetchALocation(locationId);
    }

    // 3. add a location
    // http://localhost:7474/locations
    @PostMapping("/locations")
    public LocationDto addLocation(@RequestBody LocationDto newLocation) {
        return locationService.addLocation(newLocation);
    }

    // 4. update a location
    // http://localhost:7474/locations
    @PutMapping("/locations")
    public LocationDto updateLocation(@RequestBody LocationDto updateLocation) {
        return locationService.updateLocation(updateLocation);
    }

    // 5. delete a location
    // http://localhost:7474/locations/3
    @DeleteMapping("/locations/{aid}")
    public void removeLocation(@PathVariable("aid") int locationId) {
        locationService.removeLocation(locationId);
    }

}





