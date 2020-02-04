package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;

import java.util.List;

public interface HallSensorCounterRepository extends JpaRepository<HallSensorCounter, Long> {


    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByHour();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByDay();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-01 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-01 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByMonth();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-01-01 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-01-01 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalSensorQuantitiesByYear();

    @Query(value="SELECT sum(quantity) AS sumQuantity FROM `hall_sensor_counter`", nativeQuery = true)
    public int getTotalSensorQuantities();


}
