package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.HallSensorCounterRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_WEIGHT_PER_RATE;

@Service
public class CoalConsumptionService {

    private HallSensorCounterRepository hallSensorCounterRepository;

    @Autowired
    public CoalConsumptionService(HallSensorCounterRepository hallSensorCounterRepository) {
        this.hallSensorCounterRepository = hallSensorCounterRepository;
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsLastDayByHour(){
        return hallSensorCounterRepository.getCoalConsumptionsLastDayByHour()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsLastWeekByHour(){
        return hallSensorCounterRepository.getCoalConsumptionsLastWeekByHour()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsLastMonthByDay(){
        return hallSensorCounterRepository.getCoalConsumptionsLastMonthByDay()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsLastYearByMonth(){
        return hallSensorCounterRepository.getCoalConsumptionsLastYearByMonth()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsAllYearsByYear(){
        return hallSensorCounterRepository.getCoalConsumptionsAllYearsByYear()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }


    public List<CoalConsumptionDTO> getCoalConsumptionsForDateByHour(String date){
        return hallSensorCounterRepository.getCoalConsumptionsForDateByHour(date)
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsForDateByDay(String date){
        return hallSensorCounterRepository.getCoalConsumptionsForDateByDay(date)
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsForDateByMonth(String date){
        return hallSensorCounterRepository.getCoalConsumptionsForDateByMonth(date)
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getCoalConsumptionsForDateByYear(String date){
        return hallSensorCounterRepository.getCoalConsumptionsForDateByYear(date)
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }


    public List<CoalConsumptionDTO> getTotalCoalConsumptionsByHour(){
        return hallSensorCounterRepository.getTotalCoalConsumptionsByHour()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getTotalCoalConsumptionsByDay(){
        return hallSensorCounterRepository.getTotalCoalConsumptionsByDay()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getTotalCoalConsumptionsByMonth(){
        return hallSensorCounterRepository.getTotalCoalConsumptionsByMonth()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }

    public List<CoalConsumptionDTO> getTotalCoalConsumptionsByYear(){
        return hallSensorCounterRepository.getTotalCoalConsumptionsByYear()
                .stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        hallSensorCounterDTO.getSumQuantity()*COAL_WEIGHT_PER_RATE))
                .collect(Collectors.toList());
    }
}
