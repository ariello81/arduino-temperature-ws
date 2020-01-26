package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.CoalSupplyDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalSupply;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.CoalSupplyRepository;

import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_SUPPLY_MAX_KG;
import static pl.ryzykowski.arduino.arduinotemperaturews.config.Globals.COAL_SUPPLY_COEFFICIENT;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoalSupplyService {

    private CoalSupplyRepository coalSupplyRepository;

    @Autowired
    public CoalSupplyService(CoalSupplyRepository coalSupplyRepository) {
        this.coalSupplyRepository = coalSupplyRepository;
    }

    public CoalSupply addCoalSupply(CoalSupply coalSupply) {
        return coalSupplyRepository.save(coalSupply);
    }

    public List<CoalSupplyDTO> getAllCoalSupplies() {
        return coalSupplyRepository.findAll()
                .stream()
                .map(coalSupply
                        -> new CoalSupplyDTO(coalSupply.getTimestamp(),
                        COAL_SUPPLY_MAX_KG - coalSupply.getDistance()*COAL_SUPPLY_COEFFICIENT))
                .collect(Collectors.toList());
    }

    public CoalSupply getLastCoalSupply(){
        return coalSupplyRepository.findTopByOrderByTimestampDesc();
    }
}
