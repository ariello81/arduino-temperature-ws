package pl.ryzykowski.arduino.arduinotemperaturews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalConsumptionService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coal-consumption")
public class CoalConsumptionController {

    private CoalConsumptionService coalConsumptionService;

    @Autowired
    public CoalConsumptionController(CoalConsumptionService coalConsumptionService) {
        this.coalConsumptionService = coalConsumptionService;
    }

    @CrossOrigin
    @GetMapping("/total")
    public ResponseEntity<List<List<CoalConsumptionDTO>>> getTotalCoalConsumptions(){
        List<List<CoalConsumptionDTO>> total = new ArrayList<>();
        total.add(coalConsumptionService.getTotalCoalConsumptionsByHour());
        total.add(coalConsumptionService.getTotalCoalConsumptionsByDay());
        total.add(coalConsumptionService.getTotalCoalConsumptionsByMonth());
        total.add(coalConsumptionService.getTotalCoalConsumptionsByYear());
        return ResponseEntity.ok(total);
    }

    @CrossOrigin
    @GetMapping("/last-day")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastDay(){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsLastDayByHour());
    }

    @CrossOrigin
    @GetMapping("/last-week")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastWeek(){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsLastWeekByHour());
    }

    @CrossOrigin
    @GetMapping("/last-month")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastMonth(){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsLastMonthByDay());
    }

    @CrossOrigin
    @GetMapping("/last-year")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsLastYear(){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsLastYearByMonth());
    }

    @CrossOrigin
    @GetMapping("/all-years")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsAllYears(){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsAllYearsByYear());
    }

    @CrossOrigin
    @GetMapping("/by-hour/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByHour(@PathVariable("date") String date){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsForDateByHour(date));
    }

    @CrossOrigin
    @GetMapping("/by-day/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByDay(@PathVariable("date") String date){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsForDateByDay(date));
    }

    @CrossOrigin
    @GetMapping("/by-month/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByMonth(@PathVariable("date") String date){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsForDateByMonth(date));
    }

    @CrossOrigin
    @GetMapping("/by-year/{date}")
    public ResponseEntity<List<CoalConsumptionDTO>> getCoalConsumptionsForDateByYear(@PathVariable("date") String date){
        return ResponseEntity.ok(coalConsumptionService.getCoalConsumptionsForDateByYear(date));
    }

}
