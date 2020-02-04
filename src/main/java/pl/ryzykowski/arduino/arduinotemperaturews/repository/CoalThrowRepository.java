package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.CoalThrow;

public interface CoalThrowRepository extends JpaRepository<CoalThrow, Long> {

    @Query(value="SELECT sum(kg_value) AS sumKgValue FROM `coal_throw`", nativeQuery = true)
    public int getAllCoalThrowsSum();
}
