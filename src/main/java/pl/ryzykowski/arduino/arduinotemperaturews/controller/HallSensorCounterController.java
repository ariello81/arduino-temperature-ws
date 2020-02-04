package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;
import pl.ryzykowski.arduino.arduinotemperaturews.service.HallSensorCounterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hall-sensor-counter")
public class HallSensorCounterController {

    private HallSensorCounterService hallSensorCounterService;

    @Autowired
    public HallSensorCounterController(HallSensorCounterService hallSensorCounterService) {
        this.hallSensorCounterService = hallSensorCounterService;
    }

    @PostMapping
    public ResponseEntity<HallSensorCounter> add(@RequestBody HallSensorCounter hallSensorCounter){
        return ResponseEntity.ok(hallSensorCounterService.add(hallSensorCounter));
    }


    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<HallSensorCounter>> getAllSensorCounters(){
        return ResponseEntity.ok(hallSensorCounterService.getAllSensorCounters());
    }

    @CrossOrigin
    @GetMapping("/total")
    public ResponseEntity<Integer> getTotalSensorQuantities(){
        return ResponseEntity.ok(hallSensorCounterService.getTotalSensorsQuantities());
    }



}
