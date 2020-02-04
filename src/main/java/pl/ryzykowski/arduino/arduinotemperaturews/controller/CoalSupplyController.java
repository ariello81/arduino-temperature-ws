package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalThrowService;
import pl.ryzykowski.arduino.arduinotemperaturews.service.HallSensorCounterService;

import java.math.BigDecimal;

import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_WEIGHT_PER_RATE;

@RestController
@RequestMapping("/coal-supply")
public class CoalSupplyController {

    private CoalThrowService coalThrowService;
    private HallSensorCounterService hallSensorCounterService;

    @Autowired
    public CoalSupplyController(CoalThrowService coalThrowService, HallSensorCounterService hallSensorCounterService) {
        this.coalThrowService = coalThrowService;
        this.hallSensorCounterService = hallSensorCounterService;
    }

    @CrossOrigin
    @GetMapping
    public BigDecimal getCoalSupply(){
        int totalSensorsQuantities = hallSensorCounterService.getTotalSensorsQuantities();
        int allCoalThrowsSum = coalThrowService.getAllCoalThrowsSum();
        return (new BigDecimal (allCoalThrowsSum)).subtract(COAL_WEIGHT_PER_RATE.multiply(new BigDecimal(totalSensorsQuantities)));
    }

}
