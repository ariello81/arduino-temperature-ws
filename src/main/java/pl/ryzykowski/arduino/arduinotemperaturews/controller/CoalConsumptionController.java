package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalConsumptionDTOService;
import pl.ryzykowski.arduino.arduinotemperaturews.service.HallSensorCounterService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coal-consumption")
public class CoalConsumptionController {

    private CoalConsumptionDTOService coalConsumptionDTOService;
    private HallSensorCounterService hallSensorCounterService;

    @Autowired
    public CoalConsumptionController(CoalConsumptionDTOService coalConsumptionDTOService, HallSensorCounterService hallSensorCounterService) {
        this.coalConsumptionDTOService = coalConsumptionDTOService;
        this.hallSensorCounterService = hallSensorCounterService;
    }

    @CrossOrigin
    @GetMapping("/total")
    public ResponseEntity<List<List<CoalConsumptionDTO>>> getTotalCoalConsumptions(){
        List<List<CoalConsumptionDTO>> total = new ArrayList<>();
        total.add(coalConsumptionDTOService.getTotalCoalConsumption(hallSensorCounterService.getTotalSensorQuantitiesByHour()));
        total.add(coalConsumptionDTOService.getTotalCoalConsumption(hallSensorCounterService.getTotalSensorQuantitiesByDay()));
        total.add(coalConsumptionDTOService.getTotalCoalConsumption(hallSensorCounterService.getTotalSensorQuantitiesByMonth()));
        total.add(coalConsumptionDTOService.getTotalCoalConsumption(hallSensorCounterService.getTotalSensorQuantitiesByYear()));
        return ResponseEntity.ok(total);
    }

}
