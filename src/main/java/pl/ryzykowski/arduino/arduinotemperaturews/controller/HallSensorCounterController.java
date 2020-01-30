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
    @GetMapping("/total")
    public ResponseEntity<List<List<CoalConsumptionDTO>>> getTotalCoalConsumptions(){
        List<List<CoalConsumptionDTO>> total = new ArrayList<>();
        total.add(hallSensorCounterService.getTotalCoalConsumptionsByHour());
        total.add(hallSensorCounterService.getTotalCoalConsumptionsByDay());
        total.add(hallSensorCounterService.getTotalCoalConsumptionsByMonth());
        total.add(hallSensorCounterService.getTotalCoalConsumptionsByYear());
        return ResponseEntity.ok(total);
    }

    @CrossOrigin
    @GetMapping("/last-day")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastDay(){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsLastDayByHour());
    }

    @CrossOrigin
    @GetMapping("/last-week")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastWeek(){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsLastWeekByHour());
    }

    @CrossOrigin
    @GetMapping("/last-month")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastMonth(){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsLastMonthByDay());
    }

    @CrossOrigin
    @GetMapping("/last-year")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastYear(){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsLastYearByMonth());
    }

    @CrossOrigin
    @GetMapping("/all-years")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsAllYears(){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsAllYearsByYear());
    }

    @CrossOrigin
    @GetMapping("/by-hour/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByHour(@PathVariable("date") String date){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsForDateByHour(date));
    }

    @CrossOrigin
    @GetMapping("/by-day/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByDay(@PathVariable("date") String date){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsForDateByDay(date));
    }

    @CrossOrigin
    @GetMapping("/by-month/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByMonth(@PathVariable("date") String date){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsForDateByMonth(date));
    }

    @CrossOrigin
    @GetMapping("/by-year/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByYear(@PathVariable("date") String date){
        return ResponseEntity.ok(hallSensorCounterService.getCoalConsumptionsForDateByYear(date));
    }

}
