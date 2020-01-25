package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class CoalSupplyDTO {

    @JsonProperty("x")
    private Timestamp timestamp;

    @JsonProperty("y")
    private double supplyValue;

    public CoalSupplyDTO() {
    }

    public CoalSupplyDTO(Timestamp timestamp, double supplyValue) {
        this.timestamp = timestamp;
        this.supplyValue = supplyValue;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getSupplyValue() {
        return supplyValue;
    }

    public void setSupplyValue(double supplyValue) {
        this.supplyValue = supplyValue;
    }
}
