package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public interface CoalConsumptionDTO {

    @JsonProperty("x")
    String getDate();

    @JsonProperty("y")
    double getConsumptionValue();

}
