package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Timestamp;

public class CoalConsumptionDTO {

    @JsonProperty("x")
    private Timestamp date;

    @JsonProperty("y")
    private double consumptionValue;

    public CoalConsumptionDTO() {
    }

    public CoalConsumptionDTO(Timestamp date, double consumptionValue) {
        this.date = date;
        this.consumptionValue = consumptionValue;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(double consumptionValue) {
        this.consumptionValue = consumptionValue;
    }
}
