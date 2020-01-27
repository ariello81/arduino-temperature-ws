package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.HallSensorCounterRepository;

@Service
public class HallSensorCounterService {

    private HallSensorCounterRepository hallSensorCounterRepository;

    @Autowired
    public HallSensorCounterService(HallSensorCounterRepository hallSensorCounterRepository) {
        this.hallSensorCounterRepository = hallSensorCounterRepository;
    }


    public HallSensorCounter add(HallSensorCounter hallSensorCounter) {
        return hallSensorCounterRepository.save(hallSensorCounter);
    }
}
