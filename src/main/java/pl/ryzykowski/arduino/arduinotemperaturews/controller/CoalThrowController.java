package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalThrowService;

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

}
