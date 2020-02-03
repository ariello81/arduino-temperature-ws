package pl.ryzykowski.arduino.arduinotemperaturews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.ryzykowski.arduino.arduinotemperaturews.dto.HallSensorCounterDTO;
import pl.ryzykowski.arduino.arduinotemperaturews.entity.HallSensorCounter;

import java.util.List;

public interface HallSensorCounterRepository extends JpaRepository<HallSensorCounter, Long> {

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp >= DATE_SUB(NOW(),INTERVAL 1 DAY) GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsLastDayByHour();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp >= DATE_SUB(NOW(),INTERVAL 1 WEEK) GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsLastWeekByHour();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp >= DATE_SUB(NOW(),INTERVAL 1 MONTH) GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsLastMonthByDay();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp >= DATE_SUB(NOW(),INTERVAL 1 YEAR) GROUP BY DATE_FORMAT(timestamp,'%Y-%m')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsLastYearByMonth();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` GROUP BY DATE_FORMAT(timestamp,'%Y')",
            nativeQuery=true)
    public List<HallSensorCounterDTO> getCoalConsumptionsAllYearsByYear();


    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp LIKE :date% GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getCoalConsumptionsForDateByHour(@Param("date") String date);

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp LIKE :date% GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getCoalConsumptionsForDateByDay(@Param("date") String date);

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp LIKE :date% GROUP BY DATE_FORMAT(timestamp,'%Y-%m')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getCoalConsumptionsForDateByMonth(@Param("date") String date);

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "WHERE timestamp LIKE :date% GROUP BY DATE_FORMAT(timestamp,'%Y')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getCoalConsumptionsForDateByYear(@Param("date") String date);


    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d %H:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d %H:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalCoalConsumptionsByHour();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-%d 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-%d 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalCoalConsumptionsByDay();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-%m-01 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-%m-01 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalCoalConsumptionsByMonth();

    @Query(value="SELECT DATE_FORMAT(timestamp,'%Y-01-01 00:00:00') AS date, sum(quantity) AS sumQuantity FROM `hall_sensor_counter` " +
            "GROUP BY DATE_FORMAT(timestamp,'%Y-01-01 00:00:00')",
            nativeQuery = true)
    public List<HallSensorCounterDTO> getTotalCoalConsumptionsByYear();


}
