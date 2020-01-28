package pl.ryzykowski.arduino.arduinotemperaturews.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoalConsumptionDTO {

    @JsonProperty("x")
    private String date;

    @JsonProperty("y")
    private double consumptionValue;

    public CoalConsumptionDTO() {
    }

    public CoalConsumptionDTO(String date, double consumptionValue) {
        this.date = date;
        this.consumptionValue = consumptionValue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getConsumptionValue() {
        return consumptionValue;
    }

    public void setConsumptionValue(double consumptionValue) {
        this.consumptionValue = consumptionValue;
    }
}
