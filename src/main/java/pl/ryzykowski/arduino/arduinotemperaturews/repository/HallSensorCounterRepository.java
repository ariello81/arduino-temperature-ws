package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;

import java.util.List;

public interface HallSensorCounterRepository extends JpaRepository<HallSensorCounter, Long> {

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsByDay();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsByHour();

}
