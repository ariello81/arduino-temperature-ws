package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalConsumptionDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_WEIGHT_PER_RATE;

@Service
public class CoalConsumptionDTOService {


    public List<CoalConsumptionDTO> getTotalCoalConsumption(List<HallSensorCounterDTO> hallSensorQuantitiesList){
        return hallSensorQuantitiesList.stream()
                .map(hallSensorCounterDTO -> new CoalConsumptionDTO(Timestamp.valueOf(hallSensorCounterDTO.getDate()),
                        COAL_WEIGHT_PER_RATE.multiply(new BigDecimal(hallSensorCounterDTO.getSumQuantity()))))
                .collect(Collectors.toList());
    }


}
