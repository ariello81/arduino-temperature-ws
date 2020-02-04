package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Location;


public interface LocationRepository extends JpaRepository<Location, Long> {

    public Location findByDescription(String description);

}
