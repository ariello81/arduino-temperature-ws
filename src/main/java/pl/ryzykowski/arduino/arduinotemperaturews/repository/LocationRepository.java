package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.Location;

import java.nio.file.LinkOption;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    public Location findByDescription(String description);

}
