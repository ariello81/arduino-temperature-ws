package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalSupply;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.CoalSupplyRepository;

import java.util.List;

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

    public List<CoalSupply> getAllCoalSupplies() {
        return coalSupplyRepository.findAll();
    }
}
