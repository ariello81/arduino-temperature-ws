package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
}
