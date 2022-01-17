package pl.ryzykowski.arduino.arduinotemperaturews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.ryzykowski.arduino.arduinotemperaturews.config.Globals;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.LocationRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.repository.TemperatureRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperatureService {

    TemperatureRepository temperatureRepository;
    LocationRepository locationRepository;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository, LocationRepository locationRepository) {
        this.temperatureRepository = temperatureRepository;
        this.locationRepository = locationRepository;
    }

    public void addTemperature(Temperature temperature){
        temperature.setLocation(locationRepository.findById(temperature.getLocationId()).get());
        temperatureRepository.save(temperature);
    }

    public List<Temperature> getAllTemperatures(){
        return temperatureRepository.findAll();
    }

    public List<Temperature> getTemperaturesForLocation(String location){
        return temperatureRepository.findAll().stream()
                .filter(temperature -> temperature.getLocation().getDescription().equals(location))
                .collect(Collectors.toList());
    }

    public void removeTemperatureByLocationAndDateLessThan(String location, String date) {
        java.sql.Timestamp timestamp = java.sql.Timestamp.valueOf(date);
        temperatureRepository.removeByLocationDescriptionAndTimestampLessThan(location, timestamp);
    }
}
