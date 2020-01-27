package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;

public interface HallSensorCounterRepository extends JpaRepository<HallSensorCounter, Long> {
}
