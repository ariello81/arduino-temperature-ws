package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalConsumption;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalConsumptionService;

import java.util.List;

@RestController
@RequestMapping("/coal-consumption")
public class CoalConsumptionController {

    private CoalConsumptionService coalConsumptionService;

    @Autowired
    public CoalConsumptionController(CoalConsumptionService coalConsumptionService) {
        this.coalConsumptionService = coalConsumptionService;
    }

    @GetMapping
    public ResponseEntity<List<CoalConsumption>> getAllCoalConsumptions(){
        return ResponseEntity.ok(coalConsumptionService.getAllCoalConsumptions());
    }


}
