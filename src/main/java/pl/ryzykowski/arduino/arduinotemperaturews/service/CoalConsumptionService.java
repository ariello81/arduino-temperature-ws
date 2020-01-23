package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalConsumption;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.CoalConsumptionRepository;

import java.util.List;

@Service
public class CoalConsumptionService {

    private CoalConsumptionRepository coalConsumptionRepository;

    @Autowired
    public CoalConsumptionService(CoalConsumptionRepository coalConsumptionRepository) {
        this.coalConsumptionRepository = coalConsumptionRepository;
    }

    public List<CoalConsumption> getAllCoalConsumptions() {
        return coalConsumptionRepository.findAll();
    }
}
