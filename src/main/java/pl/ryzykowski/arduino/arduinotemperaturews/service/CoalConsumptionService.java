package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.CoalConsumptionRepository;

@Service
public class CoalConsumptionService {

    private CoalConsumptionRepository coalConsumptionRepository;

    @Autowired
    public CoalConsumptionService(CoalConsumptionRepository coalConsumptionRepository) {
        this.coalConsumptionRepository = coalConsumptionRepository;
    }
}
