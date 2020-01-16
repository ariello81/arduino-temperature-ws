package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Location;
import pl.ryzykowski.arduino.arduinotemperaturews.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {

    LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Location>> getLocations(){
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @PostMapping
    public ResponseEntity<Location> addLocation(@RequestBody Location location){
        return ResponseEntity.ok(locationService.addLocation(location));
    }

    @GetMapping("/by")
    public ResponseEntity<Location> getByDescription(@RequestParam("desc") String description){
        return ResponseEntity.ok(locationService.getByDescription(description));
    }


}
