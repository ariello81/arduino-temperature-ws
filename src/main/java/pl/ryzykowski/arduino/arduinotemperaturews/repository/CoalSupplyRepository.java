package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalSupply;

public interface CoalSupplyRepository extends JpaRepository<CoalSupply, Long> {
}
