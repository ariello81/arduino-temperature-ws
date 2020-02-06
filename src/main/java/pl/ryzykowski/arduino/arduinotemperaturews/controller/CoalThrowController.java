package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalThrowService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/coal-throw")
public class CoalThrowController {

    private CoalThrowService coalThrowService;

    @Autowired
    public CoalThrowController(CoalThrowService coalThrowService) {
        this.coalThrowService = coalThrowService;
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<Object> addCoalThrow(@ModelAttribute("kgValue") String kgValue) throws URISyntaxException {
        coalThrowService.addCoalThrow(new CoalThrow(Integer.valueOf(kgValue)));
        URI uri = new URI("http://arduino-temperature-ws.herokuapp.com/add_coal_throw.html");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<CoalThrow>> getAllCoalThrows(){
        return ResponseEntity.ok(coalThrowService.getAllCoalThrows());
    }

}
