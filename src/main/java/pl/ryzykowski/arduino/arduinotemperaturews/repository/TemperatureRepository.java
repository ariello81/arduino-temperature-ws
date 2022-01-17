package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Temperature;

import java.time.LocalDateTime;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

    void removeByLocationDescriptionAndTimestampLessThan(String location, java.sql.Timestamp timestamp);

}
