package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.TemperatureDto;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Location;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.LocationRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.TemperatureRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureService {

    TemperatureRepository temperatureRepository;
    LocationRepository locationRepository;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository,
                              LocationRepository locationRepository) {
        this.temperatureRepository = temperatureRepository;
        this.locationRepository = locationRepository;
    }

    public void addTemperature(TemperatureDto temperatureDto){
        Location location = locationRepository.findById(temperatureDto.getLocationId()).get();
        Temperature temperature = new Temperature(temperatureDto.getValue(), location);
        temperatureRepository.save(temperature);
    }

    public List<Temperature> getAllTemperatures(){
        return temperatureRepository.findAll();
    }

    public List<Temperature> getTemperaturesForLocation(String location){
        System.out.println("loca:" + location);
        return temperatureRepository.findAll().stream()
                .filter(temperature -> temperature.getLocation().getDescription().equals(location))
                .collect(Collectors.toList());
    }
}
