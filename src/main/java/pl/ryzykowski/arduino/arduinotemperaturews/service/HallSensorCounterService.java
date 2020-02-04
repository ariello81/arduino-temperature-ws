package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.HallSensorCounterRepository;

import java.util.List;


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

    public List<HallSensorCounter> getAllSensorCounters() {
        return hallSensorCounterRepository.findAll();
    }

    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByHour(){
        return hallSensorCounterRepository.getTotalSensorQuantitiesByHour();
    }

    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByDay(){
        return hallSensorCounterRepository.getTotalSensorQuantitiesByDay();
    }

    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByMonth(){
        return hallSensorCounterRepository.getTotalSensorQuantitiesByMonth();
    }

    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByYear(){
        return hallSensorCounterRepository.getTotalSensorQuantitiesByYear();
    }

    public int getTotalSensorsQuantities(){
        return hallSensorCounterRepository.getTotalSensorQuantities();
    }
}
