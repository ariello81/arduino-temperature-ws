package pl.ryzykowski.arduino.arduinotemperaturews.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalConsumption;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalConsumptionService;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalSupplyService;

@Service
public class ScheduledTaskService {

    private CoalConsumptionService coalConsumptionService;
    private CoalSupplyService coalSupplyService;

    @Autowired
    public ScheduledTaskService(CoalConsumptionService coalConsumptionService, CoalSupplyService coalSupplyService) {
        this.coalConsumptionService = coalConsumptionService;
        this.coalSupplyService = coalSupplyService;
    }

    public CoalConsumption addCoalConsumption(){
       return null;
    }

}
