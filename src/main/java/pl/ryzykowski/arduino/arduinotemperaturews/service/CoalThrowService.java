package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.CoalThrowRepository;

import java.util.List;

@Service
public class CoalThrowService {

    private CoalThrowRepository coalThrowRepository;

    @Autowired
    public CoalThrowService(CoalThrowRepository coalThrowRepository) {
        this.coalThrowRepository = coalThrowRepository;
    }

    public CoalThrow addCoalThrow(CoalThrow coalThrow) {
        return coalThrowRepository.save(coalThrow);
    }

    public int getAllCoalThrowsSum(){
        return coalThrowRepository.getAllCoalThrowsSum();
    }

    public List<CoalThrow> getAllCoalThrows(){
        return coalThrowRepository.findAll();
    }
}
