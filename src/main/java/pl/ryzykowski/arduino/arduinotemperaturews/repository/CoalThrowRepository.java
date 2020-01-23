package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;

public interface CoalThrowRepository extends JpaRepository<CoalThrow, Long> {
}
