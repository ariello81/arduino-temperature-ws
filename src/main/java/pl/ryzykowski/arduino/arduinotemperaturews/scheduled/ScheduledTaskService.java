package pl.ryzykowski.arduino.arduinotemperaturews.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalConsumptionService;
import pl.ryzykowski.arduino.arduinotemperaturews.service.CoalSupplyService;

@Service
public class ScheduledTaskService {

    private CoalSupplyService coalSupplyService;

    @Autowired
    public ScheduledTaskService(CoalSupplyService coalSupplyService) {
        this.coalSupplyService = coalSupplyService;
    }


}
