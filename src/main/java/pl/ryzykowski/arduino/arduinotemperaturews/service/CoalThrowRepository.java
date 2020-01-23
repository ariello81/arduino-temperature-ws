package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoalThrowRepository {

    private CoalThrowRepository coalThrowRepository;

    @Autowired
    public CoalThrowRepository(CoalThrowRepository coalThrowRepository) {
        this.coalThrowRepository = coalThrowRepository;
    }
}
