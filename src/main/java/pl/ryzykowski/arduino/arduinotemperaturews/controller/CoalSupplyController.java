package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalSupply;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalSupplyService;

import java.util.List;

@RestController
@RequestMapping("/coal-supply")
public class CoalSupplyController {

    private CoalSupplyService coalSupplyService;

    @Autowired
    public CoalSupplyController(CoalSupplyService coalSupplyService) {
        this.coalSupplyService = coalSupplyService;
    }

    @PostMapping
    public ResponseEntity<CoalSupply> addCoalSupply (@RequestBody CoalSupply coalSupply){
        return ResponseEntity.ok(coalSupplyService.addCoalSupply(coalSupply));
    }

    public ResponseEntity<List<CoalSupply>> getAllCoalSupplies(){
        return ResponseEntity.ok(coalSupplyService.getAllCoalSupplies());
    }
}
