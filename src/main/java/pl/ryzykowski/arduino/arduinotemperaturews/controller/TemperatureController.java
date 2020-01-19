package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;
import pl.ryzykowski.arduino.arduinotemperaturews.service.TemperatureService;

import java.util.List;

@RestController
@RequestMapping("/temperature")
public class TemperatureController {

    TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping
    public void addTemperature(@RequestBody Temperature temperature){
        temperatureService.addTemperature(temperature);
    }

    @GetMapping
    public ResponseEntity<List<Temperature>> getAllTemperatures(){
        return ResponseEntity.ok(temperatureService.getAllTemperatures());
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<Temperature>> getTemperaturesForLocation (@PathVariable("location") String location) {
        return ResponseEntity.ok(temperatureService.getTemperaturesForLocation(location));
    }

}
