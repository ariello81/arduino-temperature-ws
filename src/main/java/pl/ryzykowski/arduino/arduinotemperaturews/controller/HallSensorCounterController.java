package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;
import pl.ryzykowski.arduino.arduinotemperaturews.service.HallSensorCounterService;

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
}
