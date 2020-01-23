package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalConsumption;

public interface CoalConsumptionRepository extends JpaRepository<CoalConsumption, Long> {
}
