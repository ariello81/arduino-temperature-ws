package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalThrowService;

import java.util.List;

@RestController
@RequestMapping("/coal-throw")
public class CoalThrowController {

    private CoalThrowService coalThrowService;

    @Autowired
    public CoalThrowController(CoalThrowService coalThrowService) {
        this.coalThrowService = coalThrowService;
    }

    @PostMapping
    public ResponseEntity<CoalThrow> addCoalThrow(@RequestBody CoalThrow coalThrow){
        return ResponseEntity.ok(coalThrowService.addCoalThrow(coalThrow));
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<CoalThrow>> getAllCoalThrows(){
        return ResponseEntity.ok(coalThrowService.getAllCoalThrows());
    }

}
