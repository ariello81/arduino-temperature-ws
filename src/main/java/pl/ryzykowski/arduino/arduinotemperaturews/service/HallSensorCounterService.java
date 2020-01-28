package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.HallSensorCounterRepository;

import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_WEIGHT_PER_RATE;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CoalConsumptionDTO> getCoalConsumptionsByDay(){
        return hallSensorCounterRepository.getCoalConsumptionsByDay()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(hallSensorCounterDTO.getDate(),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsByHour(){
        return hallSensorCounterRepository.getCoalConsumptionsByHour()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(hallSensorCounterDTO.getDate(),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }
}
