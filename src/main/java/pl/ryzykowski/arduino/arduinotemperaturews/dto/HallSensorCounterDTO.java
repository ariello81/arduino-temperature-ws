package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public interface HallSensorCounterDTO {

    String getDate();

    int getSumQuantity();

}
